package com.my_todolist.entities;

import javax.persistence.*;

@Entity
@Table
public class Task
{
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String task;
    @Column
    private String owner;

    public Task()
    {

    }

    public Task(Long id, String task, String owner)
    {
        this.id = id;
        this.task = task;
        this.owner = owner;
    }

    public Task(String task, String owner)
    {
        this.task = task;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString()
    {
        return "Task{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}