package controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import domain.User;
import services.UserService;

@Controller
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, String> login(HttpServletRequest request) {
		logger.info("Inside login method");
		Map<String, String> resultMap = new HashMap<String, String>();
		HttpSession session = request.getSession(true);

		if (session.getAttribute("userInfo") == null) {
			String email = request.getParameter("username");
			String password = request.getParameter("password");

			try {
				User user = userService.getUserByEmail(email);

				if (user != null) {
					String userPassword = user.getPassword();
					String hashedPassword = DigestUtils.md5DigestAsHex(password.getBytes());

					if (hashedPassword.equals(userPassword)) {
						session.setAttribute("userInfo", user);
						resultMap.put("status", "true");
						resultMap.put("message", "User logged in successfully!");

					} else {
						logger.info("Incorect username or password!");
						resultMap.put("status", "false");
						resultMap.put("message", "Incorect username or password!");
					}

				}
			} catch (Exception e) {
				logger.error("in login method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
				e.printStackTrace();
				resultMap.put("status", "false");
				resultMap.put("message", "Error logging user in!");
			}
		} else {
			resultMap.put("status", "false");
			resultMap.put("message", "User already logged in!");
		}

		return resultMap;
	}
	
	@RequestMapping(value = "logout")
	public ModelAndView logout(HttpSession session) {
		if(session != null){
			session.invalidate();
		}
		
		return new ModelAndView("../index");
	}
	
	@RequestMapping(value = "test", produces = "application/json")
	@ResponseBody
	public User loginTest(HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		return user;
	}
}
