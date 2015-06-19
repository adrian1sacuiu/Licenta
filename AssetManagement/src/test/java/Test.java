import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.User;
import services.UsersService;

public class Test {

	public static void main(String[] args) {
		/*@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		UsersService usersService = (UsersService)ctx.getBean("usersService");
		
		try {
			User user = new User();
			user.setUsername("test");
			user.setPassword("test");
			user.setEmail("test@test.com");
			//usersService.addUser(user);
			
			user.setIdUser(3l);
			user.setPassword("test2");
			usersService.updateUser(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String message = "com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry 'test' for key 'USERNAME_UNIQUE'";
		message = message.substring(message.lastIndexOf("Exception") + "Exception".length() + 2);
		System.out.println(message);
	}
}
