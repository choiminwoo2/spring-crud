import logo from "./logo.svg";
import "./App.css";
import { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const [testMessage, setTestMessage] = useState([]);

  useEffect(() => {
    const getData = async () => {
      const post = await axios.get("/hello");
      setTestMessage(post.data);
    };
    getData();
  }, []);
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <ul>
          {testMessage.map((text, index) => (
            <li key={`${index}-${text}`}>{text}</li>
          ))}
        </ul>
      </header>
    </div>
  );
}

export default App;
