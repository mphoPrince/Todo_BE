package com.example.restfulwebservices.todo;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:4200")
public class Todo {
  private long id;
  private String username;
  private String description;
  private Date targetDate;
  private boolean completed;


  protected Todo(){

  }
    public Todo(long id, String username, String description, Date targetDate, boolean completed) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo todo)) return false;
        return getId() == todo.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
