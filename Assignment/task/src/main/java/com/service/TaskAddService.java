package com.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TaskDao;
import com.dto.TaskFormDto;

import com.model.Task;

@Service
public class TaskAddService {

	@Autowired
	private TaskDao taskDao;

	public void service(TaskFormDto taskFormDto) {
		Task task = new Task();

		task.setAssignee(taskFormDto.getAssignee());
		task.setCategory(taskFormDto.getPriority());
		task.setCity(taskFormDto.getCity());
		task.setCreatedDate(LocalDateTime.now());
		task.setDiscription(taskFormDto.getDiscription());
		task.setDueDate(taskFormDto.getDate());
		task.setName(taskFormDto.getTaskName());
		
		taskDao.taskSave(task);

	}

	public List<Task> serviceList() {
		List<Task> tasks = taskDao.gettasks();
		return tasks;
	}

	public void update(int id , TaskFormDto taskFormDto) {
		List<Task> tasks = taskDao.gettasksbyId(id);
		Task task = tasks.get(0);
		task.setAssignee(taskFormDto.getAssignee());
		task.setCategory(taskFormDto.getPriority());
		task.setCity(taskFormDto.getCity());
		task.setModifiedDate(LocalDateTime.now());
		task.setDiscription(taskFormDto.getDiscription());
		task.setDueDate(taskFormDto.getDate());
		task.setName(taskFormDto.getTaskName());
		
		taskDao.taskUpdate(task);

	}
	
	public void delete(int id) {
		List<Task> tasks = taskDao.gettasksbyId(id);
		Task task = tasks.get(0);
		task.setDeleted(true);
		taskDao.taskUpdate(task);

	}

}
