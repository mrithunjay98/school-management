package com.gyanjyoti.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gyanjyoti.login.ClassTeacherLogin;
import com.gyanjyoti.login.PrincipleLogin;
import com.gyanjyoti.repo.CteacherRepo;
import com.gyanjyoti.repo.principalrepo;
import org.springframework.web.bind.annotation.SessionAttributes;




@Controller
public class PrincipleController {
	

	
	
	@Autowired
private principalrepo repo;

	
	@RequestMapping("/VerifyprincipleLogin")
	public String verifyLogin(@RequestParam String username, @RequestParam String password,ModelMap m){
	
	
		System.out.println(username+password);
		PrincipleLogin findByemail = repo.findByemail(username);
		
		String email2 = findByemail.getEmail();
		String password2 = findByemail.getPassword();
		
		System.out.println("sucess");
		System.out.println("sucess");
	
	
		
		if(username.equals(email2)&&password.equals(password2)) {
			
			System.out.println("sucess");
			  m.addAttribute("name",findByemail.getName());
			  m.addAttribute("email",email2);
			
		
			return "principle";
			
		}else {
				return "Not_found";
			}
		
		
		
	
	}

@RequestMapping("/createClassteacher")
public String studentform(@RequestParam("name")String name,@RequestParam("email")String email, ModelMap m) {

  m.addAttribute("email",email);
  m.addAttribute("name",name);
//   String userId = (String) session.getAttribute("userId");
  return "createClassTeacher";
  
}

	
	
	
}
