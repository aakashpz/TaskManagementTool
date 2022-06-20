package com.task.manager.tool.service;

import java.util.Date;
import java.util.List;

import com.task.manager.tool.model.TaskManagement;

public interface TaskManagementService {
	
	List<TaskManagement> findAllTaskByName(String name);
	List<TaskManagement> findAllTaskByStatus(String name, String status);
	List<TaskManagement> findAllDueTasksByName(String name, Date date);
	List<TaskManagement> findAllOverdueTasksByName(String name);
	List<TaskManagement> findAllTasks();
	List<TaskManagement> findAllOverdueTasks();
	List<TaskManagement> findAllTaskByStatus(String status);
	TaskManagement saveOrUpdateTask(TaskManagement task);
	void deleteTaskbyId(String Id);
}
