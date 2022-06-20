package com.task.manager.tool.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.manager.tool.model.TaskManagement;
import com.task.manager.tool.repository.TaskManagementRepository;

@Service 
public class TaskManagementServiceImpl implements TaskManagementService {
	
	@Autowired
	private TaskManagementRepository taskRepository;

	@Override
	public List<TaskManagement> findAllTaskByName(String name) {
		
		return taskRepository.findAllTaskByName(name);
	}

	@Override
	public List<TaskManagement> findAllTaskByStatus(String name, String status) {
		
		return taskRepository.findAllTaskByStatus(name, status);
	}

	@Override
	public List<TaskManagement> findAllDueTasksByName(String name, Date date) {
		
		return taskRepository.findAllDueTasksByName(name, date);
	}

	@Override
	public List<TaskManagement> findAllOverdueTasksByName(String name) {
		
		return taskRepository.findAllOverdueTasksByName(name);
	}

	@Override
	public List<TaskManagement> findAllTasks() {
		
		return taskRepository.findAll();
	}

	@Override
	public List<TaskManagement> findAllOverdueTasks() {
		
		return taskRepository.findAllOverdueTasks();
	}

	@Override
	public List<TaskManagement> findAllTaskByStatus(String status) {
		
		return taskRepository.findAllTaskByName(status);
	}

	@Override
	public TaskManagement saveOrUpdateTask(TaskManagement task) {
		return taskRepository.save(task);
	}

	@Override
	public void deleteTaskbyId(String Id) {
		taskRepository.deleteById(Id);
		
	}

}
