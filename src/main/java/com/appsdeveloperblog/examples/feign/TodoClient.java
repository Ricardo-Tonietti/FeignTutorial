package com.appsdeveloperblog.examples.feign;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "TodoClient", url = "https://jsonplaceholder.typicode.com")
public interface TodoClient {

	@GetMapping(value = "/todos", consumes = MediaType.APPLICATION_JSON)
	List<TodoModel> getTodos();

	/*
	 * @GetMapping(value="/{id}",consumes=MediaType.APPLICATION_JSON) TodoClient
	 * getTodoId(@PathVariable("id") int id);
	 */

	@GetMapping(value = "/todos/{id}", consumes = "application/Json")
	TodoModel getTodoId(@PathVariable("id") int id);
	
	@RequestMapping(method = RequestMethod.GET, value = "/posts")
    List<PostModel> getPosts();
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
    List<PostModel> getusers();
	
	

}
