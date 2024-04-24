package com.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.persistence.PostLoad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.TaskFormDto;
import com.model.Task;
import com.service.TaskAddService;

@Controller
public class MainController {
	
	@Autowired
	private TaskAddService taskAddService;
	
	@RequestMapping("/tasks")
	public String taskShow(Model model)
	
	{
		List<Task> tasks = taskAddService.serviceList();
		model.addAttribute("tasks" , tasks);
		return ("/taskView");
	}
	
	@PostMapping("/addTask")
	public String taskadd(@ModelAttribute TaskFormDto taskFormDto)
	{
		System.out.println("helloo");
		taskAddService.service(taskFormDto);
		return "redirect:/tasks"; 
	}
	
	@PostMapping("/updateTask")
	public String taskadd(@RequestParam("taskid") int id, @ModelAttribute TaskFormDto taskFormDto)
	{
		System.out.println("helloo");
		taskAddService.update(id, taskFormDto);
		return "redirect:/tasks"; 
	}
	
	
	@RequestMapping("/delete/{id}")
	public String taskdelete(Model model, @PathVariable("id") int id)
	
	{
		taskAddService.delete(id);
		return "redirect:/tasks"; 
	}
	
	

}
