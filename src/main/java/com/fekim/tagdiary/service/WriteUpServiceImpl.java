package com.fekim.tagdiary.service;

import com.fekim.tagdiary.entity.Tag;
import com.fekim.tagdiary.entity.WriteUp;
import com.fekim.tagdiary.repository.WriteUpRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class WriteUpServiceImpl implements WriteUpService{

    private final WriteUpRepository repository;

    @Override
    public Tag getMod(String tagType) {

        List<Long> list = repository.getTnoListByTagType(tagType);

        int targetRno = getTargetRno(list);

        Optional<WriteUp> result = repository.findById((long) targetRno);

        if(result.isPresent()){
            return result.get().getTag();
        }

        return null;
    }

    /* 찾는 Tag는 가장 인기 있는 Tag입니다.
    *  아래 메서드로 조회해야 할 Tag의 tno를 찾습니다.
    * */
    public int getTargetRno(List<Long> list){

        Long max = -1L;
        for(Long i : list){
            if(i > max){
                max = i;
            }
        }

        int[] arr = new int[max.intValue()+1];

        for(Long i : list){
            arr[i.intValue()]++;
        }

        int tmpMax = -1;
        int targetRno = -1;
        for(int i=0; i<arr.length; ++i){
            if(arr[i] > tmpMax){
                tmpMax = arr[i];
                targetRno = i;
            }
        }

        return targetRno;
    }

}
