package com.example.task.management.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.management.ResourceNotFoundException.ResourceNotFoundException;
import com.example.task.management.model.Task;
import com.example.task.management.repository.TaskRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class TaskManagementController {
	
	@Autowired
	private TaskRepository taskRepository;
	Logger logger = LoggerFactory.getLogger(TaskManagementController.class);
	@GetMapping("/tasks")
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	
	@GetMapping("/tasks/overdue")
	public List<Task> findOverdueTask(@RequestParam("date") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
		return taskRepository.findOverdueTasks(date);
	}
	
	@GetMapping("/tasks/due")
	public List<Task> findDueTask() {
		return taskRepository.findDueTasks(new Date(new Date().getTime() - (1000 * 60 * 60 * 24))
				,new Date(new Date().getTime() + (1000 * 60 * 60 * 24)));
	}
	
	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") String id) throws ResourceNotFoundException {
		Task Task = taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + id));
		return ResponseEntity.ok().body(Task);
	}

	@PostMapping("/tasks")
	public Task createTask(@Valid @RequestBody Task task) {
		return taskRepository.save(task);
	}

	@PutMapping("/tasks/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable(value = "id") String id, @Valid @RequestBody Task taskDto)
			throws ResourceNotFoundException {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + id));
		task.setDate(taskDto.getDate());
		task.setDescription(taskDto.getDescription());
		task.setId(id);
		task.setName(taskDto.getName());
		task.setPriority(taskDto.getPriority());
		task.setStatus(taskDto.getStatus());
		task.setTaskname(taskDto.getTaskname());
		final Task updateTask = taskRepository.save(task);
		return ResponseEntity.ok(updateTask);
	}
	
	@PatchMapping("/tasks/{id}")
	public ResponseEntity<Task> updateTaskStatus(@PathVariable(value = "id") String id, @Valid @RequestParam("status")  String status)
			throws ResourceNotFoundException {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + id));
		
		task.setStatus(status);
		final Task updateTask = taskRepository.save(task);
		return ResponseEntity.ok(updateTask);
	}
	
	@DeleteMapping("/tasks/{_id}")
	public Map<String, Boolean> deleteTask(@PathVariable(value = "_id") String id) throws ResourceNotFoundException {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + id));

		taskRepository.delete(task);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
