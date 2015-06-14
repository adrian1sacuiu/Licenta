import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.User;
import services.AssetService;
import services.UserService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		UserService userService = (UserService)ctx.getBean("userService");
		AssetService assetService = (AssetService)ctx.getBean("assetService");
		
		User user = userService.getUserByEmail("tst@test.com");
		System.out.println(assetService.getAssetsForUser(1l));
		
	}
}
