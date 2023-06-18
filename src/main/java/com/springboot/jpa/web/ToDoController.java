package com.springboot.jpa.web;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.dao.ToDoRepository;
import com.springboot.jpa.dao.ToDoService;
import com.springboot.jpa.entities.ToDo;


@RestController
@RequestMapping("/toDo")
public class ToDoController {
	private final ToDoService toDoService;
	private final ToDoRepository toDoRepository;
	
	public ToDoController (ToDoRepository toDoRepository, ToDoService toDoService) {
		this.toDoRepository = toDoRepository;
        this.toDoService = toDoService;
    }


	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveUserData(@RequestBody ToDo toDoData) {
        toDoRepository.save(toDoData);
    }
	
	 @GetMapping
	 public List<ToDo> getAllUsers() {
		 	List<ToDo> retrievedData = toDoService.getAllUsers();
		
	        return retrievedData;
	 }
	 
	 @PutMapping("/{id}")
	    public void updateData(@PathVariable String id, @RequestBody ToDo updatedData) {
	      ToDo toDoToUpdate = toDoRepository.findById(String.valueOf(id)).get();
	        toDoToUpdate.setId(updatedData.getId());
	        toDoToUpdate.setTitle(updatedData.getTitle());
	        toDoToUpdate.setDescription(updatedData.getDescription());
	        toDoToUpdate.setStatus(updatedData.getStatus());
	        toDoRepository.save(toDoToUpdate);
	        
	   }
	 
	 @DeleteMapping("/{id}")
	 public void deleteData(@PathVariable String id) {
		 toDoRepository.deleteById(String.valueOf(id));
		 
	 }
}
