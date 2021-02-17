package com.my_todolist.controllers;

import com.my_todolist.entities.Task;
import com.my_todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/task")
public class TaskController
{
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService)
    {
        this.taskService = taskService;
    }

    @PostMapping("create")
    public Task addTask(@RequestBody Task task)
    {
        return taskService.addTask(task);
    }

    @GetMapping("read/{owner}")
    public List<Task> getTasks(@PathVariable("owner") String owner)
    {
        return taskService.getTasks(owner);
    }

    @DeleteMapping("delete/{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId)
    {
        taskService.deleteTask(taskId);
    }
}
