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




@Controller
public class principle {
	

	
	
	@Autowired
private principalrepo repo;

	
	@RequestMapping("/VerifyprincipleLogin")
	public String verifyLogin(@ModelAttribute("abcd") PrincipleLogin ct,ModelMap m){
		
		String email = ct.getEmail();
		String password = ct.getPassword();
		System.out.println(email+password);
		PrincipleLogin findByemail = repo.findByemail(email);
		
		String email2 = findByemail.getEmail();
		String password2 = findByemail.getPassword();
		
		System.out.println("sucess");
		System.out.println("sucess");
	
	
		
		if(email.equals(email2)&&password.equals(password2)) {
			
			System.out.println("sucess");
			
		
			return "Class_teachers";
			
		}else {
				return "invalid password";
			}
		
		
		
	
	}

	
	
	
}
