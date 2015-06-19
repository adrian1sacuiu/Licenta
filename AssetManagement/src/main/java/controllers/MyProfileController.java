package controllers;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entities.Asset;
import entities.Complaint;
import entities.Request;
import entities.Transaction;
import services.AssetService;
import services.ComplaintService;
import services.RequestService;
import services.TransactionService;

@PreAuthorize("isAuthenticated()")
@Controller
public class MyProfileController {
	private static final Logger logger = Logger.getLogger(MyProfileController.class);
	
	@Autowired
	private AssetService assetService;
	
	@Autowired
	private ComplaintService complaintService;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private TransactionService transactionService;
	
	@PreAuthorize("(hasRole('ROLE_USER') and #username == principal.username) or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "userAssets/{username}", produces = "application/json")
	public List<Asset> getUserAssets(@PathVariable String username, ModelAndView modelAndView){
		logger.info("Inside getUserAssets method");
		List<Asset> userAssets = null;
		
		modelAndView.setViewName("#userAssets");
		try{
			userAssets = assetService.getAssetsByUser(username);
			modelAndView.addObject(userAssets);
			
		} catch(Exception e){
			logger.error("in getUserAssets method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			modelAndView.addObject("error", "Error getting user assets!");
		}
		
		return userAssets;
	}
	
	@PreAuthorize("(hasRole('ROLE_USER') and #username == principal.username) or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "userComplaints/{username}", produces = "application/json")
	@ResponseBody
	public List<Complaint> getUserComplaints(@PathVariable String username, ModelAndView modelAndView){
		logger.info("Inside getUserComplaints method");
		List<Complaint> userComplaints = null;
		
		modelAndView.setViewName("#userComplaints");
		try{
			userComplaints = complaintService.getComplaintsByUser(username);
			modelAndView.addObject(userComplaints);
			
		} catch(Exception e){
			logger.error("in getUserComplaints method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			modelAndView.addObject("error", "Error getting user complaints!");
		}
		
		return userComplaints;
	}
	
	@PreAuthorize("(hasRole('ROLE_USER') and #username == principal.username) or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "userRequests/{username}", produces = "application/json")
	@ResponseBody
	public List<Request> getUserRequests(@PathVariable String username, ModelAndView modelAndView){
		logger.info("Inside getUserRequests method");
		List<Request> userRequests = null;
		
		modelAndView.setViewName("#userRequests");
		try{
			userRequests = requestService.getRequetsByUser(username);
			modelAndView.addObject(userRequests);
			
		} catch(Exception e){
			logger.error("in getUserRequests method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			modelAndView.addObject("error", "Error getting user requests!");
		}
		
		return userRequests;
	}
	
	@PreAuthorize("(hasRole('ROLE_USER') and #username == principal.username) or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "userTransactions/{username}", produces = "application/json")
	@ResponseBody
	public List<Transaction> getUserTransactions(@PathVariable String username, ModelAndView modelAndView){
		logger.info("Inside getUserTransactions method");
		List<Transaction> userTransactions = null;
		
		modelAndView.setViewName("#userTransactions");
		
		try{
			userTransactions = transactionService.getTransactionsByUser(username);
			modelAndView.addObject(userTransactions);
			
		} catch(Exception e){
			logger.error("in getUserTransactions method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			modelAndView.addObject("error", "Error getting user transactions!");
		}
		
		return userTransactions;
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "testPrincipal", produces = "application/json")
	@ResponseBody
	public Principal testPrincipal(@AuthenticationPrincipal Principal principal){
		logger.info("Inside testPrincipal method");
		return principal;
	}
	
}