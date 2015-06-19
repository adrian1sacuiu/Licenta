package controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import services.AssetService;
import services.ComplaintService;
import services.TransactionService;
import services.UsersService;
import entities.Asset;
import entities.Complaint;
import entities.Transaction;
import entities.User;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
public class AdminController {
	private static final Logger logger = Logger.getLogger(AdminController.class);
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private AssetService assetService;
	
	@Autowired
	private ComplaintService complaintService;
	
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value = "getAllUsers", produces = "application/json")
	@ResponseBody
	public List<User> getAllUsers(){
		logger.info("Inside getAllUsers method");
		List<User> users = null;
		
		try{
			users = usersService.getAllUsers();
			
		} catch(Exception e){
			logger.error("in getAllUsers method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
		}
		
		return users;
	}
	
	@RequestMapping(value = "getAllAssets", produces = "application/json")
	@ResponseBody
	public List<Asset> getAllAssets(){
		logger.info("Inside getAllUsers method");
		List<Asset> assets = null;
		
		try{
			assets = assetService.getAllAssets();
			
		} catch(Exception e){
			logger.error("in getAllAssets method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
		}
		
		return assets;
	}
	
	@RequestMapping(value = "getAllComplaints", produces = "application/json")
	@ResponseBody
	public List<Complaint> getAllComplaints(){
		logger.info("Inside getAllComplaints method");
		List<Complaint> complaints = null;
		
		try{
			complaints = complaintService.getAllComplaints();
			
		} catch(Exception e){
			logger.error("in getAllComplaints method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
		}
		
		return complaints;
	}
	
	@RequestMapping(value = "getAllTransactions", produces = "application/json")
	@ResponseBody
	public List<Transaction> getAllTransactions(){
		logger.info("Inside getAllTransactions method");
		List<Transaction> transactions = null;
		
		try{
			transactions = transactionService.getAllTransactions();
			
		} catch(Exception e){
			logger.error("in getAllTransactions method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
		}
		
		return transactions;
	}
}
