package com.gyanjyoti.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gyanjyoti.login.ClassTeacherLogin;
import com.gyanjyoti.login.PrincipleLogin;
import com.gyanjyoti.repo.CteacherRepo;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;





@Controller
public class ClassTeacher {
	

	
	
	@Autowired
private CteacherRepo repo;
	
	 @PostMapping("/createClassTeacher")
	    public String saveUser(@ModelAttribute ClassTeacherLogin user, Model model) {
	      
	        System.out.println("User details saved: " + user);

	        repo.save(user);
	        model.addAttribute("message", "User saved successfully!");
	        
	        // Redirect to a success or confirmation page
	        return "principle";
	    }
	  @RequestMapping("/VerifyClassTeacherlogin")
	    public String verifyLogin(@ModelAttribute("abcd") ClassTeacherLogin ct, Model m) {
	       
	        String email = ct.getEmail();
	        String password = ct.getPassword();
	        
	  	  System.out.println("input email"+email);
		  System.out.println("input password"+password);
		
	        ClassTeacherLogin findByEmail = repo.findByemail(email);
	        System.out.println("database email"+findByEmail.getEmail());
			  System.out.println("database password"+findByEmail.getPassword());
	        if (findByEmail != null) {
	         
	        	if (password.equals(findByEmail.getPassword()) && email.equals(findByEmail.getEmail())) {
	        	   
	        	
        m.addAttribute("name", findByEmail.getName());
        m.addAttribute("id", findByEmail.getId());
        m.addAttribute("classs", findByEmail.getRoomNo());
        m.addAttribute("email", findByEmail.getEmail());
        m.addAttribute("id", findByEmail.getClassTeacher_id());


	                
	               
	                return "Class_teachers";
	            } else {
	              
	                m.addAttribute("error", "Invalid password");
	                return "login"; // Return the login view again
	            }
	        } else {
	          
	            m.addAttribute("error", "No account found with this email");
	            return "login";
	        }
	    }
	  
	@RequestMapping("/redirect")
	public String studentform(@RequestParam("name")String s3,@RequestParam("className")String s,
			@RequestParam("email") String s2,@RequestParam("id") String id, ModelMap m) {
		  m.addAttribute("className",s);
		  m.addAttribute("email",s2);
		  m.addAttribute("name",s3);
		  m.addAttribute("id",id);
		  
		  System.out.println(s);
		  System.out.println(s2);
		  System.out.println(s3);
		
		  return "create_student";
		  
	  }
	
	
	
}
