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
		userService.createUser(user);

		user = null;
		user = userService.getUserByName("Adrian").get(0);
		System.out.println(user);
	}
}
