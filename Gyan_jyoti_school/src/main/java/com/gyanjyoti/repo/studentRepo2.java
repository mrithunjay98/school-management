package com.gyanjyoti.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gyanjyoti.entity.Student;
import com.gyanjyoti.login.ClassTeacherLogin;


public interface studentRepo2 extends JpaRepository<Student, Long> {
	Student	findByemail(String email);

	 @Query(value = "SELECT * FROM student WHERE class_teacher_id = :classTeacherId", nativeQuery = true)
	    List<Student> findByClassTeacherIdNative(@Param("classTeacherId") String classTeacherId);

}
