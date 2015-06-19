package controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import services.UsersService;
import entities.User;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
public class AdminController {
	private static final Logger logger = Logger.getLogger(AdminController.class);
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value = "getAllUsers", produces = "application/json")
	@ResponseBody
	public List<User> getAllUsers(){
		logger.info("Inside getAllUsers method");
		List<User> users = null;
		try{
			users = usersService.getAllUsers();
			
		} catch(Exception e){
			logger.error("in getAllUsers method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
		}
		
		return users;
	}
}
