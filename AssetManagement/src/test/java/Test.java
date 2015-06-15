import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import domain.User;
import services.AssetService;
import services.UsersService;

public class Test {

	public static void main(String[] args) {
		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		UsersService userService = (UsersService)ctx.getBean("userService");
		AssetService assetService = (AssetService)ctx.getBean("assetService");*/
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode("test");
		
		System.out.println(hashedPassword);
		
	}
}
