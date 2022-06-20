package com.example.task.management.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document(collection = "task_sequences")
public class Task {
	
	private String id;
	private String name;
	private String description;
	private String priority;
	private String taskname;
	private String status;
	private Date date;
	
	public Task() {
		
	}
	public Task(String id, String name, String description, String priority, String taskname, String status,
			Date date) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.taskname = taskname;
		this.status = status;
		this.date = date;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}
	/**
	 * @return the taskname
	 */
	public String getTaskname() {
		return taskname;
	}
	/**
	 * @param taskname the taskname to set
	 */
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Task {id=" + id + ", name=" + name + ", description=" + description + ", priority=" + priority
				+ ", taskname=" + taskname + ", status=" + status + ", date=" + date + "}";
	}
	 
}
