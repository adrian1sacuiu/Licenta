package controllers;

import org.apache.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@PreAuthorize("hasRole('ROLE_USER')")
@Controller
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);

}
