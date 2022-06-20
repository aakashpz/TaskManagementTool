package com.example.task.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.task.management.model.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, String>{
	@Query("{'date' : { '$lt' : ?0 }}")
	List<Task> findOverdueTasks(Date date);
	@Query("{'date' : { '$gt': ?0, '$lt' : ?1 }}")
	List<Task> findDueTasks(Date now, Date tomorrow);
}
