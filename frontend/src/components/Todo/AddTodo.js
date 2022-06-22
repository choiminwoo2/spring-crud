import { useState } from "react";
import Card from "../UI/Card";
import AddForm from "./AddForm";
import styled from "./AddTodo.module.css";
const AddTodo = () => {
  const [btnState, setBtnState] = useState(true);

  const addBtnClickHandler = () => {
    setBtnState(false);
  };

  const State = btnState ? (
    <div className={styled['new-todo']}>
      <button onClick={addBtnClickHandler}>목록 추가 열기</button>
    </div>
  ) : (
    <Card> <AddForm /></Card>
  );

  return State;
};

export default AddTodo;
