package com.spring.jpa.crud.service;


import com.spring.jpa.crud.domain.entity.TodoEntity;
import com.spring.jpa.crud.domain.repository.TodoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import org.junit.jupiter.api.Assertions.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class TodoServiceTest {

    @Autowired TodoService todoService;
    @Autowired TodoRepository todoRepository;

    @Test
    public void 할일작성() throws Exception{
        //given
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setContent("안녕하세요");
        //when
        Long savedId = todoService.todoWrite(todoEntity);
        //then
        Assertions.assertEquals(todoEntity, todoRepository.findOne(savedId));
    }
    @Test
    public void 할일삭제() throws Exception{
        //given
        String id = "1";
        //when
        List<TodoEntity> list = todoService.deleteTodo(id);
        //then
        Assertions.assertEquals(list, todoRepository.findAll());
    }
}
