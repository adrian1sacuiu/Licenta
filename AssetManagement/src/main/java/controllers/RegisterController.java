package controllers;

import entities.User;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import services.UsersService;
import util.ImageUploadException;
import static util.OperationsUtils.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "register")
public class RegisterController {
	private static final Logger logger = Logger.getLogger(RegisterController.class);

	@Autowired
	private UsersService userService;

	@PreAuthorize("isAnonymous()")
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView createUser() {
		logger.info("Inside createUser method");

		ModelAndView mv = new ModelAndView("register");
		mv.addObject("user", new User());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	@PreAuthorize("isAnonymous()")
	public Map<String, String> registerUser(@ModelAttribute("user") User user, @RequestParam(value = "image", required = false) MultipartFile image) {
		logger.info("Inside registerUser method");
		Map<String, String> resultMap = new HashMap<String, String>();

		try {
			String username = user.getUsername();
			
			if (!image.isEmpty()) {
				validateImage(image);
				saveImage(username, image);
			}
			
			String password = user.getPassword();
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);
			user.setPassword(hashedPassword);
			
			userService.addUser(user);
			resultMap.put("status", "true");
			resultMap.put("message", "User registered successfully!");

		} catch (ImageUploadException iue) {
			logger.error("in registerUser method ImageUploadException: " + iue.getMessage() + "; Cause: " + iue.getCause());
			resultMap.put("status", "false");
			resultMap.put("message", iue.getMessage());
			
		} catch (Exception e) {
			logger.error("in registerUser method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			resultMap.put("status", "false");
			resultMap.put("message", "Error creating user!");
		}

		return resultMap;
	}
}
