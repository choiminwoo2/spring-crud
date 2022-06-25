package com.spring.jpa.crud.controller;


import com.spring.jpa.crud.domain.entity.TodoEntity;
import com.spring.jpa.crud.domain.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoRepository todoRepository;

    @GetMapping("/todo")
    public List<TodoEntity> todoList(){
        return todoRepository.findAll();
    }
}
