import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.DigestUtils;

import domain.User;
import services.UserService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		UserService userService = (UserService)ctx.getBean("userService");
		
		User user = userService.getUserByEmail("tst@test.com");
		System.out.println(user);
		
	}
}
