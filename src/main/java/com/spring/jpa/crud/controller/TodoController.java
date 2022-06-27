package com.spring.jpa.crud.controller;


import com.spring.jpa.crud.domain.entity.TodoEntity;
import com.spring.jpa.crud.domain.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
@Transactional
public class TodoController {

    private final TodoRepository todoRepository;

    @GetMapping("/list")
    public List<TodoEntity> todoList(){
        return todoRepository.findAll();
    }

    @PostMapping("/add/{content}")
    public Map<String,Object> addTodo(@PathVariable String content){
        TodoEntity todoEntity = new TodoEntity(null,content);
        int result = todoRepository.save(todoEntity);
        Map<String,Object> map = new HashMap<String,Object>();
        if(result >= 0){
            map.put("result",result);
        }else{
            map.put("message","추가하는 것에 대해 에러가 발생.");
        }
        return map;

    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Object> deleteTodo(@PathVariable("id") String id){
        List<TodoEntity> list = todoRepository.deleteTodo(id);
        String result = null;
        if(list != null){
            result = "ok";
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("result",result);
        return map;
    }
}
