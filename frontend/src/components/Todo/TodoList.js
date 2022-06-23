import { useEffect } from "react";
import { useState } from "react";
import Card from "../UI/Card";
import TodoItem from "./TodoItem";

const TodoList = () =>{
    const [todos, setTodos] = useState([]);

    useEffect(()=>{
        const fetchTodo = async () =>{
            const response = await fetch('');
            const responseData = await response.json();
            console.log(responseData);
        }

    },[])
    return <Card>
        {todos.map((todo) =>{
            <TodoItem key={todo.id}/>
        })}
    </Card>
}

export default TodoList;