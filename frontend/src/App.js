import logo from './logo.svg';
import './App.css';
import React, {useState, useEffect} from 'react';

function App() {
  
  const [message, setMessage] = useState([]);
  useEffect(() => {
    fetch("/test")
      .then((res) => {
        return res.json();
      })
      .then((data)=>{
        setMessage(data);
      });
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        
        <ul>
          {message.tno}
          {message.name}
          {message.type}
        </ul>

      </header>
    </div>
  );
}

export default App;
