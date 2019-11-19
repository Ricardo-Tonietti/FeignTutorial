package com.appsdeveloperblog.examples.feign;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/todos", produces = MediaType.APPLICATION_JSON)
public class TodoController {

	@Autowired
	TodoClient todoClient;

	@GetMapping(produces = "application/Json")
	public List<TodoModel> getTodos() {
		return todoClient.getTodos();
	}

	@GetMapping(value = "/todos/{id}", produces = "application/Json")
	public TodoModel getTodoId(@PathVariable("id") int id) {
		System.out.println(id);
		return todoClient.getTodoId(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/posts")
    public List<PostModel> getPosts(){
		return todoClient.getPosts();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<PostModel> getusers(){
		return todoClient.getusers();
	}
	
}
