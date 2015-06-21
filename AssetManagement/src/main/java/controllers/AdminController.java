package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import services.AssetService;
import services.ComplaintService;
import services.RequestService;
import services.TransactionService;
import services.UsersService;
import entities.Asset;
import entities.Complaint;
import entities.Request;
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
	private RequestService requestService;
	
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value = "users", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getAllUsers(){
		logger.info("Inside getAllUsers method");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<User> users = null;
		
		try{
			users = usersService.getAllUsers();
			resultMap.put("status", "true");
			resultMap.put("message", users);
			
		} catch(Exception e){
			logger.error("in getAllUsers method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			resultMap.put("status", "false");
			resultMap.put("message", "Error getting users!");
		}
		
		return resultMap;
	}
	
	@RequestMapping(value = "assets", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getAllAssets(){
		logger.info("Inside getAllUsers method");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Asset> assets = null;
		
		try{
			assets = assetService.getAllAssets();
			resultMap.put("status", "true");
			resultMap.put("message", assets);
			
		} catch(Exception e){
			logger.error("in getAllAssets method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			resultMap.put("status", "false");
			resultMap.put("message", "Error getting assets!");
		}
		
		return resultMap;
	}
	
	@RequestMapping(value = "complaints", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getAllComplaints(){
		logger.info("Inside getAllComplaints method");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Complaint> complaints = null;
		
		try{
			complaints = complaintService.getAllComplaints();
			resultMap.put("status", "true");
			resultMap.put("message", complaints);
			
		} catch(Exception e){
			logger.error("in getAllComplaints method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			resultMap.put("status", "false");
			resultMap.put("message", "Error getting complaints!");
		}
		
		return resultMap;
	}
	
	@RequestMapping(value = "requests", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getAllRequests(){
		logger.info("Inside getAllRequests method");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Request> requests = null;
		
		try{
			requests = requestService.getAllRequests();
			resultMap.put("status", "true");
			resultMap.put("message", requests);
			
		} catch(Exception e){
			logger.error("in getAllRequests method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			resultMap.put("status", "false");
			resultMap.put("message", "Error getting requests!");
		}
		
		return resultMap;
	}
	
	@RequestMapping(value = "transactions", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getAllTransactions(){
		logger.info("Inside getAllTransactions method");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Transaction> transactions = null;
		
		try{
			transactions = transactionService.getAllTransactions();
			resultMap.put("status", "true");
			resultMap.put("message", transactions);
			
		} catch(Exception e){
			logger.error("in getAllTransactions method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			resultMap.put("status", "false");
			resultMap.put("message", "Error getting transactions!");
		}
		
		return resultMap;
	}
	
	@RequestMapping(value = "createAsset", method = RequestMethod.POST)
	public ModelAndView addAssetModel(){
		logger.info("Inside addAssetModel method");

		ModelAndView mv = new ModelAndView("views/createAsset.jsp");
		mv.addObject("asset", new Asset());

		return mv;
	}
	
	@RequestMapping(value = "createAsset", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, Object> createAsset(@ModelAttribute("asset") Asset asset){
		logger.info("Inside createAsset method");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try{
			boolean result = assetService.addAsset(asset);
			if(result){
				resultMap.put("status", "true");
				resultMap.put("message", "Asset created successfully!");
				
			} else {
				logger.error("Error creating new asset!");
				resultMap.put("status", "false");
				resultMap.put("message", "Error creating new asset!");
			}
			
		} catch(Exception e){
			logger.error("in createAsset method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			resultMap.put("status", "false");
			resultMap.put("message", "Error creating new asset!");
		}
		return resultMap;
	}
}
