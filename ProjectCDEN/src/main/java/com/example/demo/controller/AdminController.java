package com.example.demo.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin")
public class AdminController {

	@RequestMapping(value = {"", "/dashboard"}, method = RequestMethod.GET)
	public String dashboard(Model model, Principal principal) {
		User loginedUser = (User)((Authentication) principal).getPrincipal();
		
		model.addAttribute("userInfo", loginedUser);
		return "admin/index";
	}
	
	@RequestMapping(value = "/manage-projects", method = RequestMethod.GET)
	public String manageProjects(Model model) {
		
		return "admin/manage-projects";
	}
	
	@RequestMapping(value = "/create-project", method = RequestMethod.GET)
	public String createProject(Model model) {
		
		return "admin/create-project";
	}
	
	@RequestMapping(value = "/manage-news", method = RequestMethod.GET)
	public String manageNews(Model model) {
		
		return "admin/manage-news";
	}
	
	@RequestMapping(value = "/create-news", method = RequestMethod.GET)
	public String createNews(Model model) {
		
		return "admin/create-news";
	}
}
