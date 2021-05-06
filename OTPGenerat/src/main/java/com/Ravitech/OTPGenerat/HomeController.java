package com.Ravitech.OTPGenerat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.springBootOTPGenerator.message.OTPService;

@Controller
public class HomeController 
{
	@Value("${spring.application.name}")
    String appName;
    
    @Autowired
    public OTPService otpService;
	
	@RequestMapping(value="/dashboard",method=RequestMethod.GET)
    public String dashboard()
	{
    	System.out.println("The dashboard has to bee directed::");
        return "dashboard";
    }
	@RequestMapping(value="/",method=RequestMethod.GET)
	    public String homePage(Model model) {
	    String message = " Welcome to Home Page";
	        model.addAttribute("appName", appName);
	        model.addAttribute("message", message);
	        return "signin";
	    }
	   @RequestMapping(value="/login",method=RequestMethod.GET)
	    public String login() {
	        return "signin";
	    }
	   
	   @RequestMapping(value="/admin",method=RequestMethod.GET)
	    public String admin() {
	        return "admin";
	    }
	   @RequestMapping(value="/user",method=RequestMethod.GET)
	    public String user() {
	        return "user";
	    }
	    @RequestMapping(value="/aboutus",method=RequestMethod.GET)
	    public String about() {
	        return "aboutus";
	    }
	    @RequestMapping(value="/403",method=RequestMethod.GET)
	    public String error403() 
	    {
	        return "error/403";
	    }
	    @RequestMapping(value="/logout", method = RequestMethod.GET)
	    public @ResponseBody String logout(HttpServletRequest request, HttpServletResponse response){
	       Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
	       if (auth != null){    
	       String username = auth.getName();
	       //Remove the recently used OTP from server. 
	       otpService.clearOTP(username);
	       new SecurityContextLogoutHandler().logout(request, response, auth);
	       }
	   return "redirect:/login?logout";    
	    }
	
}
