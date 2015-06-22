package controllers;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import services.AssetService;
import services.ComplaintService;
import services.RequestService;
import services.TransactionService;
import services.UsersService;
import entities.Asset;
import entities.Complaint;
import entities.Request;
import entities.User;

@Controller
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	
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
	
	@PreAuthorize("(hasRole('ROLE_USER') and #username == principal.username)")
	@RequestMapping(value = "createRequest/{username}", produces = "application/json")
	@ResponseBody
	public Map<String, Object> createRequest(@PathVariable String username, HttpServletRequest request){
		logger.info("Inside createRequest method");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Request newRequest = new Request();
		Long idAsset = 0L;
		
		try{
			idAsset = Long.parseLong(request.getParameter("idAsset"));
			
			User user = usersService.getUserByUsername(username);
			Asset asset = assetService.getAssetById(idAsset);
			
			newRequest.setUser(user);
			newRequest.setAsset(asset);
			newRequest.setDate(new Date(System.currentTimeMillis()));
			newRequest.setStatus("New");
			
			boolean result = requestService.addRequest(newRequest);
			if(result){
				resultMap.put("status", "true");
				resultMap.put("message", "Request created successfully!");
				
			} else {
				logger.error("Error creating new request!");
				resultMap.put("status", "false");
				resultMap.put("message", "Error creating new request!");
			}
			
		} catch(Exception e){
			logger.error("in createRequest method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			resultMap.put("status", "false");
			resultMap.put("message", "Error creating new request!");
		}
		return resultMap;
	}
	
	@PreAuthorize("(hasRole('ROLE_USER') and #username == principal.username)")
	@RequestMapping(value = "createComplaint/{username}", produces = "application/json")
	@ResponseBody
	public Map<String, Object> createComplaint(@PathVariable String username, HttpServletRequest request){
		logger.info("Inside createComplaint method");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Complaint complaint = new Complaint();
		Long idAsset = 0L;
		
		try{
			idAsset = Long.parseLong(request.getParameter("idAsset"));
			
			User user = usersService.getUserByUsername(username);
			Asset asset = assetService.getAssetById(idAsset);
			
			complaint.setUser(user);
			complaint.setAsset(asset);
			
			boolean result = complaintService.addComplaint(complaint);
			if(result){
				resultMap.put("status", "true");
				resultMap.put("message", "Complaint created successfully!");
				
			} else {
				logger.error("Error creating new request!");
				resultMap.put("status", "false");
				resultMap.put("message", "Error creating new complaint!");
			}
			
		} catch(Exception e){
			logger.error("in createComplaint method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			resultMap.put("status", "false");
			resultMap.put("message", "Error creating new complaint!");
		}
		return resultMap;
	}
	
	
}
