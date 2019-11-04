package com.appsdeveloperblog.examples.feign;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="TodoClient", url="https://jsonplaceholder.typicode.com")
public interface TodoClient {
    @GetMapping(value="/todos",consumes=MediaType.APPLICATION_JSON)
    List<TodoModel> getTodos();
}
