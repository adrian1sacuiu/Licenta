import java.io.File;
import java.net.URISyntaxException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import services.UserService;
import services.UserServiceImpl;
import services.DAO.UserDao;


public class Test {
	
	@org.junit.Test
	public void test(){
			File file = new File("src/main/webapp/resources/imags/bg_bot.jpg");
			System.out.println(file.getAbsolutePath());
	}
}

/* muhahhhahhahhahahahhaha */
