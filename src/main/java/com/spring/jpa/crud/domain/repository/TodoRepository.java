package com.spring.jpa.crud.domain.repository;


import com.spring.jpa.crud.domain.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepository {

    private final EntityManager entityManager;

    public void save(TodoEntity todo){
        entityManager.persist(todo);
    };

    public TodoEntity findOne(Long id){
        return entityManager.find(TodoEntity.class, id);
    }

    public List<TodoEntity> findAll(){
        return entityManager.createQuery("select m from TodoEntity m",TodoEntity.class)
                .getResultList();
    }

    public List<TodoEntity> findByWriter(String writer) {
        return entityManager.createQuery("select m from TodoEntity m where m.writer = :writer ", TodoEntity.class)
                .getResultList();
    }
    public List<TodoEntity> deleteTodo(String str_id){
        Long id= Long.parseLong(str_id);
        TodoEntity todoEntity = entityManager.find(TodoEntity.class, id);
        if(todoEntity != null){
            entityManager.remove(todoEntity);
        }
        return entityManager.createQuery("select m from TodoEntity m", TodoEntity.class)
                .getResultList();
    }
}
