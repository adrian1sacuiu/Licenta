package controllers;

import domain.User;
import misc.ImageUploadException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import services.UserService;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * Created by internship on 8/7/2014.
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    private static final String PROJECT_PATH = "C:/Users/Adrian/Desktop/IntelliJ Projects/AssetManagement/web";

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView createUser(){
        ModelAndView mv= new ModelAndView("register");
        mv.addObject("user", new User());
        return mv;
    }
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("user") @Valid User user,BindingResult bindingResult,
                                     @RequestParam(value = "image", required = false) MultipartFile image){
        ModelAndView mv = new ModelAndView("register");
        if(bindingResult.hasErrors()){
            return mv;
        }
        userService.createUser(user);
        try {
            if(!image.isEmpty()) {
                validateImage(image);
                saveImage(user.getName() + ".jpg", image); //
            }
        } catch (ImageUploadException e) {
            bindingResult.reject(e.getMessage());
            return mv;
        }
        mv = new ModelAndView("myProfile");
        return mv;
    }

    private void validateImage(MultipartFile image) {
        if(!image.getContentType().equals("image/jpeg")) {
            throw new ImageUploadException("Only JPG images accepted");
        }
    }

    private void saveImage(String filename, MultipartFile image)
            throws ImageUploadException {
        try {
            File file = new File(PROJECT_PATH+"/resources/images/" + filename);
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException e) {
            throw new ImageUploadException("Unable to save image", e);
        }
    }
}
