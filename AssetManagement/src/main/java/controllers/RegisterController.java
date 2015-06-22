package controllers;

import entities.User;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import services.UsersService;
import util.ImageUploadException;
import static util.OperationsUtils.*;


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

		ModelAndView mv = new ModelAndView("views/register.jsp");
		mv.addObject("user", new User());

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
		/*catch (MySQLIntegrityConstraintViolationException ice) {
			logger.error("in registerUser method MySQLIntegrityConstraintViolationException: " + ice.getMessage() + "; Cause: " + ice.getCause());
			modelAndView.setViewName("#register");
			modelAndView.addObject("error", "Username or email address already exist!");
		}*/
		catch (Exception e) {
			logger.error("in registerUser method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			modelAndView.setViewName("#register");
			modelAndView.addObject("error", "Error registering new user!");
		}

		return modelAndView;
	}
}
