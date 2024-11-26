package com.gyanjyoti.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Student {
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String name;
	    private String address;
	    private String phone;
	    private String email;
	    private String fathersName;
	    private Date dob;
	    private String classTeacherId;
	    private String className;
	    private String busRouteno;
	    private String addmissionNo;
	   
	    
		
		public String getClassTeacher() {
			return classTeacherId;
		}
		public void setClassTeacher(String classTeacher) {
			this.classTeacherId = classTeacher;
		}
		public String getClassName() {
			return className;
		}
		public void setClassName(String className) {
			this.className = className;
		}
		public String getBusRouteno() {
			return busRouteno;
		}
		public void setBusRouteno(String busRouteno) {
			this.busRouteno = busRouteno;
		}
		public String getAddmissionNo() {
			return addmissionNo;
		}
		public void setAddmissionNo(String addmissionNo) {
			this.addmissionNo = addmissionNo;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFathersName() {
			return fathersName;
		}
		public void setFathersName(String fathersName) {
			this.fathersName = fathersName;
		}
		
		
		public Date getDob() {
			return dob;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
	    
	    
	    
	    // Getters and setters
	}


