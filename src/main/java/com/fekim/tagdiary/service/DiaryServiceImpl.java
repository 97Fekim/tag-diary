package com.fekim.tagdiary.service;

import com.fekim.tagdiary.dto.DiaryDTO;
import com.fekim.tagdiary.dto.PageRequestDTO;
import com.fekim.tagdiary.dto.PageResultDTO;
import com.fekim.tagdiary.dto.WriteUpDTO;
import com.fekim.tagdiary.entity.Diary;
import com.fekim.tagdiary.entity.WriteUp;
import com.fekim.tagdiary.repository.DiaryRepository;
import com.fekim.tagdiary.repository.TagRepository;
import com.fekim.tagdiary.repository.WriteUpRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@Service
@Log4j2
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService{

    /* Diary를 저장하기 위해서는 모든 Repository를 주입받아야 함 */
    private final DiaryRepository diaryRepository;

    private final WriteUpRepository writeUpRepository;

    private final TagRepository tagRepository;

    @Override
    public Long register(DiaryDTO diaryDTO) {
        Map<String, Object> entityMap = dtoToEntity(diaryDTO);

        Diary diary = (Diary) entityMap.get("diary");   // Object -> Diary

        Diary saved = diaryRepository.save(diary);// Diary 먼저 저장

        /* Diary를 저장하면서 얻어온 dno를 diaryDTO의 dno에 저장 */
        for(WriteUpDTO writeUpDTO : diaryDTO.getWriteUpDTOList()){
            writeUpDTO.setDno(saved.getDno());
        }

        // 다시 dto->entity
        entityMap = dtoToEntity(diaryDTO);

        List<WriteUp> writeUpList = (List<WriteUp>) entityMap.get("writeUpList");   // Object -> List

        writeUpList.stream().forEach(writeUp -> {
            tagRepository.save(writeUp.getTag());   // Tag 먼저 저장
            writeUpRepository.save(writeUp);
        });

        return diary.getDno();
    }

    @Transactional
    @Override   // Diary 하나 삭제
    public void removeDiaryWithWriteUps(Long dno) {

        /* 쿼리 메서드로 작성 */
        // WriteUp들 부터 삭제
        writeUpRepository.deleteByDno(dno);
        // Diary 삭제
        diaryRepository.deleteById(dno);
    }

    @Override
    public DiaryDTO read(Long dno) {
        return entityToDTO(diaryRepository.getDiaryWithWritesUpAndTags(dno));
    }

    @Override
    public PageResultDTO getListPage(PageRequestDTO pageRequestDTO, String writer) {

        Pageable pageable = pageRequestDTO.getPageable(Sort.by("dno").descending());

        List<DiaryDTO> diaryDTOList = new ArrayList<>();

        Page<Object> result = diaryRepository.getList(pageable, writer);

        int totalPages = result.getTotalPages();

        for(Object object : result){

            DiaryDTO diaryDTO = entityToDTOForPage(object);

            diaryDTO.setWriter(writer);

            diaryDTOList.add(diaryDTO);

        }

        return new PageResultDTO(diaryDTOList, totalPages);

    }

    @Override
    @Transactional
    public void modify(DiaryDTO diaryDTO) {

        // DTO -> Entity
        Diary diary = (Diary) dtoToEntity(diaryDTO).get("diary");
        List<WriteUp> writeUpList = (List<WriteUp>) dtoToEntity(diaryDTO).get("writeUpList");

        // 1. dno를 참조하는 모든 WriteUp을 삭제한다
        writeUpRepository.deleteByDno(diary.getDno());

        log.info("=================diary delete completely===========");

        // 2. Diary의 제목을 바꾼 후, 수정(save)한다.
        Optional<Diary> origin = diaryRepository.findById(diary.getDno());

        if(origin.isPresent()){

            Diary modified = origin.get();

            modified.changeTitle(diary.getTitle());

            log.info("========================dno of diary : " + modified.getDno());

            diaryRepository.save(modified);

            log.info("=================diary modified completely===========");
        }

        // 3. DiaryDTO에 들어있는 모든 WriteUp을 저장한다.
        for(WriteUp writeUp : writeUpList){

            log.info("========================dno of writeUp : " + writeUp.getDiary().getDno());
            log.info("========================tno of writeUp : " + writeUp.getTag().getTno());

            writeUpRepository.save(writeUp);

        }
        log.info("====================save writeUp completely===============");

    }

}
