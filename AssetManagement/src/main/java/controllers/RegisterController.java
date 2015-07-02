package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Department;
import entities.User;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import services.DepartmentService;
import services.UsersService;
import util.ImageUploadException;
import static util.OperationsUtils.*;


@Controller
@RequestMapping(value = "register")
public class RegisterController {
	private static final Logger logger = Logger.getLogger(RegisterController.class);

	@Autowired
	private UsersService userService;
	
	@Autowired
	private DepartmentService departmentService;

	@PreAuthorize("isAnonymous()")
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView createUser() {
		logger.info("Inside createUser method");

		ModelAndView mv = new ModelAndView("views/register.jsp");
		try{
			List<Department> departments = departmentService.getAllDepartments();
			mv.addObject("user", new User());
			mv.addObject("departments", departments);
			
		} catch(Exception e){
			logger.error("in createUser method Exception: " + e.getMessage());
		}
		return mv;
	}

	@PreAuthorize("isAnonymous()")
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public ModelAndView registerUser(@ModelAttribute("user") User user, @RequestParam(value = "image", required = false) MultipartFile image) {
		logger.info("Inside registerUser method");
		ModelAndView modelAndView = new ModelAndView("");

		try {
			String username = user.getUsername();

			if (image != null && !image.isEmpty()) {
				validateImage(image);
				saveImage(username, image);
			}

			String password = user.getPassword();
			userService.addUser(user);
			
			user.setPassword(password);
			modelAndView.addObject("registered_user", user);

		} catch (ImageUploadException iue) {
			logger.error("in registerUser method ImageUploadException: " + iue.getMessage());
			iue.printStackTrace();
			modelAndView.setViewName("#register");
			modelAndView.addObject("error", iue.getMessage());

		} 
		
		catch (Exception e) {
			logger.error("in registerUser method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			modelAndView.setViewName("#register");
			modelAndView.addObject("error", "Error registering new user!");
		}

		return modelAndView;
	}
	

	@RequestMapping(value = "departments", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getAllDepartments() {
		logger.info("Inside getAllDepartments method");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Department> departments = null;

		try {
			departments = departmentService.getAllDepartments();
			resultMap.put("status", "true");
			resultMap.put("message", departments);

		} catch (Exception e) {
			logger.error("in getAllDepartments method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			resultMap.put("status", "false");
			resultMap.put("message", "Error getting departments!");
		}

		return resultMap;
	}
}
