package com.gyanjyoti.controller;

import java.util.List;

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

import com.gyanjyoti.entity.Student;
import com.gyanjyoti.login.ClassTeacherLogin;
import com.gyanjyoti.login.PrincipleLogin;

import com.gyanjyoti.repo.studentRepo2;

;

@Controller
public class StudentController {


	@Autowired
	private studentRepo2 repo2;
	
	@RequestMapping("/VerifyStudentLogin")
	public String verifyLogin(@ModelAttribute("abcd") Student ct,ModelMap m){
		
		String email = ct.getEmail();
		String password = ct.getPassword();
		
		Student findByemail = repo2.findByemail(email);
		
		String email2 = findByemail.getEmail();
		String password2 = findByemail.getPassword();
		
		
	
	
		
		if(email.equals(email2)&&password.equals(password2)) {
			
			System.out.println("sucess");
			
		
			return "student";
			
		}else {
				return "invalid password";
			}}
	  
	
	@PostMapping("/create")
	public String saveStudent(@ModelAttribute ("abcd") Student  student) {
		
		
		repo2.save(student);
		return "Class_teachers";
		
	}
	

	@GetMapping("/listStudent1")
	public String alent() {
		
		
		
	
      return "list_student";
		
	}
	@ResponseBody
	@GetMapping("/listStudent")
	public List<Student> allStudent(Model m, @RequestParam("id") String id) {
		
		System.out.println();
		List<Student> findAll = repo2.findByClassTeacherId(id);
		m.addAttribute("students",findAll);
		System.out.println(findAll);

      return findAll;
		
	}
	
	
	
}
