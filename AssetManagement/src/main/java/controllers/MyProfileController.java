package controllers;

import static util.OperationsUtils.saveImage;
import static util.OperationsUtils.validateImage;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import entities.Asset;
import entities.Complaint;
import entities.Request;
import entities.Transaction;
import entities.User;
import services.AssetService;
import services.ComplaintService;
import services.RequestService;
import services.TransactionService;
import services.UsersService;
import util.ImageUploadException;

@PreAuthorize("isAuthenticated()")
@Controller
public class MyProfileController {
	private static final Logger logger = Logger.getLogger(MyProfileController.class);
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private AssetService assetService;
	
	@Autowired
	private ComplaintService complaintService;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private TransactionService transactionService;
	
	@PreAuthorize("#username == principal.username")
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public ModelAndView updateUser(@ModelAttribute("user") User user, HttpSession session, @RequestParam(value = "image", required = false) MultipartFile image) {
		logger.info("Inside updateUser method");
		ModelAndView modelAndView = new ModelAndView(new RedirectView(""));

		try {
			String username = user.getUsername();
			if (image != null && !image.isEmpty()) {
				validateImage(image);
				saveImage(username, image);
			}

			userService.updateUser(user);
			session.setAttribute("logged_user", user);
			
		} catch (ImageUploadException iue) {
			logger.error("in updateUser method ImageUploadException: " + iue.getMessage());
			iue.printStackTrace();
			//modelAndView.setViewName("#register");
			modelAndView.addObject("error", iue.getMessage());

		} 
		
		catch (Exception e) {
			logger.error("in updateUser method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			//modelAndView.setViewName("#register");
			modelAndView.addObject("error", "Error updating new user!");
		}

		return modelAndView;
	}
	
	@PreAuthorize("(hasRole('ROLE_USER') and #username == principal.username) or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "userAssets/{username}", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getUserAssets(@PathVariable String username){
		logger.info("Inside getUserAssets method");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Asset> userAssets = null;
		
		try{
			userAssets = assetService.getAssetsByUser(username);
			resultMap.put("status", "true");
			resultMap.put("message", userAssets);
			
		} catch(Exception e){
			logger.error("in getUserAssets method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			resultMap.put("status", "false");
			resultMap.put("message", "Error getting user assets!");
		}
		
		return resultMap;
	}
	
	@PreAuthorize("(hasRole('ROLE_USER') and #username == principal.username) or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "userComplaints/{username}", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getUserComplaints(@PathVariable String username){
		logger.info("Inside getUserComplaints method");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Complaint> userComplaints = null;
		
		try{
			userComplaints = complaintService.getComplaintsByUser(username);
			resultMap.put("status", "true");
			resultMap.put("message", userComplaints);
			
		} catch(Exception e){
			logger.error("in getUserComplaints method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			resultMap.put("status", "false");
			resultMap.put("message", "Error getting user complaints!");
		}
		
		return resultMap;
	}
	
	@PreAuthorize("(hasRole('ROLE_USER') and #username == principal.username) or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "userRequests/{username}", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getUserRequests(@PathVariable String username){
		logger.info("Inside getUserRequests method");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Request> userRequests = null;
		
		try{
			userRequests = requestService.getRequetsByUser(username);
			resultMap.put("status", "true");
			resultMap.put("message", userRequests);
			
		} catch(Exception e){
			logger.error("in getUserRequests method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			resultMap.put("status", "false");
			resultMap.put("message", "Error getting user requests!");
		}
		
		return resultMap;
	}
	
	@PreAuthorize("(hasRole('ROLE_USER') and #username == principal.username) or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "userTransactions/{username}", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getUserTransactions(@PathVariable String username){
		logger.info("Inside getUserTransactions method");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Transaction> userTransactions = null;
		
		
		try{
			userTransactions = transactionService.getTransactionsByUser(username);
			resultMap.put("status", "true");
			resultMap.put("message", userTransactions);
			
		} catch(Exception e){
			logger.error("in getUserTransactions method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			resultMap.put("status", "false");
			resultMap.put("message", "Error getting user transactions!");
		}
		
		return resultMap;
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "testPrincipal", produces = "application/json")
	@ResponseBody
	public Principal testPrincipal(@AuthenticationPrincipal Principal principal){
		logger.info("Inside testPrincipal method");
		return principal;
	}
	
}