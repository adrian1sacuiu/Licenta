package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping(value = "/testController")
	public ModelAndView test(ModelAndView modelAndView){
		
		modelAndView.setViewName("/");
		modelAndView.addObject("test", "testValue");
		return modelAndView;
	}
}
