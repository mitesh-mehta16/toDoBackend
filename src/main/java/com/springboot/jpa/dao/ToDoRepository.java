package com.springboot.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.jpa.entities.ToDo;



public interface ToDoRepository extends CrudRepository<ToDo, String> {

}
