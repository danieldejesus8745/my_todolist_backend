package com.my_todolist.repositories;

import com.my_todolist.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>
{
    @Query("SELECT t FROM Task t WHERE t.owner = ?1")
    List<Task> findTasksByOwner(String owner);
}
