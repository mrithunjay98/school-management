package com.gyanjyoti.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gyanjyoti.login.ClassTeacherLogin;
import com.gyanjyoti.login.PrincipleLogin;
import com.gyanjyoti.repo.CteacherRepo;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;

@Controller
public class ClassTeacherController {
	

	
	
	@Autowired
private CteacherRepo repo;
	
	 @PostMapping("/createClassTeacher")
	    public String saveUser(@ModelAttribute ClassTeacherLogin user, Model model) {
	      
		  Random random = new Random();
	        
	        // Generate a random 8-digit number
	        int random8DigitNumber = 10000000 + random.nextInt(90000000);
	     
            user.setClassTeacher_id(Integer.toString(random8DigitNumber));
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
	        if (password.equals(findByEmail.getPassword()) && email.equals(findByEmail.getEmail())) {
			   
			
      m.addAttribute("name", findByEmail.getName());
      m.addAttribute("id", findByEmail.getId());
      m.addAttribute("classs", findByEmail.getRoomNo());
      m.addAttribute("email", findByEmail.getEmail());
      m.addAttribute("id", findByEmail.getClassTeacher_id());

			   
			    return "Class_teachers";
			} else {
			  
			    m.addAttribute("error", "Invalid password");
			    return "Not_found"; // Return the login view again
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
	
	
	
	
	@GetMapping("/listCt")
	public String alent() {
		

	
      return "list_classTeacher";
		
	}
	
	@ResponseBody
	 @GetMapping("/classTeachers")
	    public List<ClassTeacherLogin> listCT() {
	      
	    

	        List<ClassTeacherLogin> all = repo.findAll();
	     
	        
	      
	        return all;
	    }
	
	
}
