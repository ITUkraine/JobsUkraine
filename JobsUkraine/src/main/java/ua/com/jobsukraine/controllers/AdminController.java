package ua.com.jobsukraine.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ComponentScan("ua.com.jobsukraine.service")
public class AdminController {
	@RequestMapping(value="/admin")
	public String goAdminPage(){
		return "admin";
	}
}
