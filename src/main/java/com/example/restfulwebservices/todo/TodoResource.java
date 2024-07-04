package com.example.restfulwebservices.todo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {

    @Autowired  //this imports the component below it
    private TodoHardCodedService todoHardCodedService;

    @GetMapping("/user/{username}/todos")  //the path we will use to access the method that follows ,
    // @path variable indicates that the variable will be passed from the path(url)

    public List<Todo> getAllTodos(@PathVariable String username){
        return todoHardCodedService.findAll();
    }

    @GetMapping("/user/{username}/todos/{id}")

    public Todo getTodo(@PathVariable String username, @PathVariable long id){
        return todoHardCodedService.findById(id);
    }

    //Delete("/user/{username}/todos")
    @DeleteMapping("/user/{username}/todos/{id}")

    public ResponseEntity<Void>deleteTodo(
            @PathVariable String username, @PathVariable long id) {
        Todo todo = todoHardCodedService.deleteById(id);
        if (todo != null) {
            return ResponseEntity.noContent().build();
        }
    return  ResponseEntity.notFound().build();
    }


//to Edit or update elements use PUT
    //To create a new element use Post
@PutMapping("/user/{username}/todos/{id}")
public ResponseEntity<Todo>updateTodo(
        @PathVariable String username, @PathVariable long id , @RequestBody Todo todo) {

    Todo todoUpdated = todoHardCodedService.save(todo);
    return new ResponseEntity<Todo>(todo, HttpStatus.OK);
}

    @PostMapping("/user/{username}/todos")
    public ResponseEntity<Void>updateTodo(
            @PathVariable String username , @RequestBody Todo todo) {

        Todo createdTodo = todoHardCodedService.save(todo);


        //Get current url of the new resource (updated_todo)
        //get ID

       URI uri;
        uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    }


