package com.example.task.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.task.management.model.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, String>{
	
}
