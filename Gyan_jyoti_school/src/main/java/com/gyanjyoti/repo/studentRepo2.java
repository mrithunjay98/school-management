package com.gyanjyoti.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyanjyoti.entity.Student;
import com.gyanjyoti.login.ClassTeacherLogin;
import com.gyanjyoti.login.StudentLogin;

public interface studentRepo2 extends JpaRepository<StudentLogin, Long> {
	StudentLogin	findByemail(String email);
}
