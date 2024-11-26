package com.gyanjyoti.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyanjyoti.login.ClassTeacherLogin;
import com.gyanjyoti.login.PrincipleLogin;

public interface principalrepo extends JpaRepository<PrincipleLogin, Long> {
	PrincipleLogin	findByemail(String email);
}
