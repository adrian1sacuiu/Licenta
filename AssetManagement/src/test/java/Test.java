import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import entities.User;
import services.AssetService;
import services.UsersService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		UsersService userService = (UsersService)ctx.getBean("usersService");
		
		System.out.println(userService.getUserByEmail("tst@test.com"));
	}
}
