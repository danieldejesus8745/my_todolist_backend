package com.my_todolist.services;

import com.my_todolist.entities.Task;
import com.my_todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService
{
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository)
    {
        this.taskRepository = taskRepository;
    }

    public Task addTask(Task task)
    {
        return taskRepository.save(task);
    }

    public List<Task> getTasks(Task task)
    {
        return taskRepository.findTasksByOwner(task.getOwner());
    }

    public void deleteTask(Long taskId)
    {
        taskRepository.deleteById(taskId);
    }
}
