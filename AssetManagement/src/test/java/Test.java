import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.Asset;
import entities.Request;
import entities.Transaction;
import entities.User;
import services.AssetService;
import services.ComplaintService;
import services.RequestService;
import services.TransactionService;
import services.UsersService;

public class Test {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
			//AssetService assetService = (AssetService)ctx.getBean("assetService");
			//RequestService requestService = (RequestService)ctx.getBean("requestService");
			//TransactionService transactionService = (TransactionService)ctx.getBean("transactionService");
			ComplaintService complaintService = (ComplaintService)ctx.getBean("complaintService");
			//System.out.println(transactionService.getAllTransactions());
			//System.out.println(requestService.getAllRequests());
			System.out.println(complaintService.getAllComplaints());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
