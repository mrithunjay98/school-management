package com.gyanjyoti.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gyanjyoti.entity.Student;
import com.gyanjyoti.login.ClassTeacherLogin;


public interface studentRepo2 extends JpaRepository<Student, Long> {
	Student	findByemail(String email);

	
	@Query("SELECT s FROM Student s WHERE s.classTeacherId LIKE %:classTeacherId%")
	List<Student> findByClassTeacherIdLike(@Param("classTeacherId") String classTeacherId);


}
