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
import com.gyanjyoti.repo.principalrepo;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;

@Controller
public class ClassTeacherController {
	

	@Autowired
private principalrepo repoPrincipal;
	
	@Autowired
private CteacherRepo repo;
	
	 @PostMapping("/createClassTeacher")
	    public String saveUser(@RequestParam("namePrince") String principleName,@RequestParam("emailPrince") String principleEmail,@ModelAttribute ClassTeacherLogin user, Model m) {
	      
		  Random random = new Random();
	        
	     
		  int random4DigitNumber = 1000 + random.nextInt(9000);

	     
            user.setClassTeacher_id(Integer.toString(random4DigitNumber));
	        repo.save(user);
	        m.addAttribute("message", "User saved successfully!");
	        PrincipleLogin findByemail = repoPrincipal.findByemail(principleEmail);
	        
	        m.addAttribute("name",findByemail.getName());
			  m.addAttribute("email",principleEmail);
	      
	        return "principle";
	    }
	  @RequestMapping("/VerifyClassTeacherlogin")
	    public String verifyLogin(@ModelAttribute("abcd") ClassTeacherLogin ct, Model m) {
	       
	        String email = ct.getEmail();
	        String password = ct.getPassword();
	        
	  	  System.out.println("input email"+email);
		  System.out.println("input password"+password);
		
	        ClassTeacherLogin findByEmail = repo.findByemail(email);
	        if (findByEmail == null) {
	            m.addAttribute("error", "Email not found");
	            return "Not_found"; 
	        }
	        if (password.equals(findByEmail.getPassword()) && email.equals(findByEmail.getEmail())) {
			   
			
      m.addAttribute("name", findByEmail.getName());
      m.addAttribute("id", findByEmail.getId());
      m.addAttribute("classs", findByEmail.getRoomNo());
      m.addAttribute("email", findByEmail.getEmail());
      m.addAttribute("id", findByEmail.getClassTeacher_id());

			   
			    return "Class_teachers";
			} else {
			  
			    m.addAttribute("error", "Invalid password");
			    return "Not_found"; 
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
