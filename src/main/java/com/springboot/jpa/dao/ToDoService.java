package com.springboot.jpa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.entities.ToDo;

import java.util.List;

@Service
public class ToDoService {
    private final ToDoRepository todoRepository;

    @Autowired
    public ToDoService(ToDoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<ToDo> getAllUsers() {
        return (List<ToDo>) todoRepository.findAll();
    }
}
