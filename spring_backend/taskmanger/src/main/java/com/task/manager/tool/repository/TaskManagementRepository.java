package com.task.manager.tool.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.task.manager.tool.model.TaskManagement;

import java.util.Date;
import java.util.List;

public interface TaskManagementRepository extends MongoRepository<TaskManagement, String>{
	
	List<TaskManagement> findAllTaskByName(String name);
	List<TaskManagement> findAllTaskByStatus(String name, String status);
	List<TaskManagement> findAllDueTasksByName(String name, Date date);
	List<TaskManagement> findAllOverdueTasks();
	List<TaskManagement> findAllTaskByStatus(String status);
	List<TaskManagement> findAllOverdueTasksByName(String name);
	List<TaskManagement> findAllTasks();
}
