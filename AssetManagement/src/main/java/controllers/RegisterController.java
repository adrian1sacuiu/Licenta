package controllers;

import domain.User;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import services.UsersService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "register")
public class RegisterController {
	private static final Logger logger = Logger.getLogger(RegisterController.class);

	@Autowired
	private UsersService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView createUser() {
		logger.info("Inside createUser method");
		
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("user", new User());
		
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, String> registerUser(@ModelAttribute("user") User user) {
		logger.info("Inside registerUser method");
		Map<String, String> resultMap = new HashMap<String, String>();
		
		try {
			String password = user.getPassword();
			String hashedPassword = DigestUtils.md5DigestAsHex(password.getBytes());
			
			user.setPassword(hashedPassword);
			userService.addUser(user);
			resultMap.put("status", "true");
			resultMap.put("message", "User registered successfully!");
			
		} catch (Exception e) {
			logger.error("in registerUser method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			resultMap.put("status", "false");
			resultMap.put("message", "Error creating user!");
		}	
			
		
		return resultMap;
	}
}
