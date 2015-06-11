import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.User;
import services.UserService;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		UserService userService = (UserService) ctx.getBean("userService");

		User user = new User();
		user.setName("Adrian");
		user.setEmail("sacuiu_adrian@yahoo.com");
		userService.addUser(user);

		user = null;
		user = userService.getUsersByName("Adrian").get(0);
		System.out.println(user);
	}
}
