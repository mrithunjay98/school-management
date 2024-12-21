package com.gyanjyoti.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyanjyoti.entity.Student;
import com.gyanjyoti.login.ClassTeacherLogin;


public interface studentRepo2 extends JpaRepository<Student, Long> {
	Student	findByemail(String email);

	List<Student> findByClassTeacherId(String id);
}
