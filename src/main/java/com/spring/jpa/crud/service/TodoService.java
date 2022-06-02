package com.spring.jpa.crud.service;

import com.spring.jpa.crud.domain.entity.TodoEntity;
import com.spring.jpa.crud.domain.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;



    /*
    *   todo 작성
    * */
    @Transactional
    public Long todoWrite(TodoEntity todo){

        todoRepository.save(todo);
        return todo.getId();

    }

}
