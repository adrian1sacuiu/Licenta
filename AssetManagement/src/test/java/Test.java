import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.Request;
import entities.User;
import services.RequestService;
import services.UsersService;

public class Test {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
			RequestService requestService = (RequestService)ctx.getBean("requestService");
			Request request = new Request();
			request.setDate(new Date(System.currentTimeMillis()));
			
			requestService.addRequest(request);
			System.out.println(requestService.getRequestById(request.getIdRequest()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
