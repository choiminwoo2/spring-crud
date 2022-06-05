
import "./App.css";
import React, { Fragment, useEffect, useState } from "react";
import axios from "axios";
import AddTodo from "./components/Todo/AddTodo";
import TodoList from "./components/Todo/TodoList";

function App() {
  
  return (
    <Fragment>
      <AddTodo />
      <TodoList />
    </Fragment>
  )
}

export default App;
