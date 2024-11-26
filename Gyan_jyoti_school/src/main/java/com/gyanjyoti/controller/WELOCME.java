package com.gyanjyoti.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;





@Controller
public class WELOCME {

	
	



	    private static HttpSession appSession;
	   
	    // Getter for appSession
	    public static HttpSession getAppSession() {
	        return appSession;
	    }

	    // Setter for appSession
	//    public static void setAppSession(HttpSession appSession) {
	   //     SessionManager.appSession = appSession;
	 //   }
	

	
	@RequestMapping("/home")
	public String home() {
		
		
		return"welcome";
	}
	@RequestMapping("/about")
	public String about() {
		
		
		return"about";
	}
	@RequestMapping("/fees")
	public String fee() {
		
		
		return"fees structure";
	}
	
	@RequestMapping("/classteacherLogin")
	public String classTeacherLogin() {
		
		
		return"Class_Teacher_Login";
	}
	@RequestMapping("/studentLogin")
	public String studentLogin() {
		
		
		return"student_login";
	}
	
	@RequestMapping("/principalLogin")
	public String principalLogin() {
		
		
		return"principal_login";
	}
	
	
}
