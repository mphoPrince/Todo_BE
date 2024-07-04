package com.example.restfulwebservices.todo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@CrossOrigin(origins = "http://localhost:4200")
@Service  //add the @service annotation to indicate it's a service
public class TodoHardCodedService {
    //the service is acting as a database
    private static List<Todo> todos = new ArrayList();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "Prince", "Learn java", new Date(), false));
        todos.add(new Todo(++idCounter, "Prince", "Learn Angular", new Date(), false));
        todos.add(new Todo(++idCounter, "Prince", "Learn Micro Services 2", new Date(), false));
        todos.add(new Todo(++idCounter, "Prince", "Learn AWS", new Date(), false));
    }

    public List<Todo> findAll() {
        return todos; //this returns all the todos in the service
    }


    public Todo deleteById(long id){
        Todo todo  = findById(id);
        if(todo ==null) return  null;

        if(todos.remove(todo)){
            return todo;
        }
        return null;

    }

    public Todo findById(long id) {
        for(Todo todo:todos){
            if(todo.getId()==id ){
                return todo;
            }
        }
        return null;
    }

    public Todo save(Todo todo){
        if(todo.getId()==-1 || todo.getId()==0){
            todo.setId(++idCounter);
    todos.add(todo);
        }
        else{
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

}
