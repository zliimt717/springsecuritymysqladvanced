package com.example.springsecuritymysqladvanced;

import com.example.springsecuritymysqladvanced.entity.AppUser;
import com.example.springsecuritymysqladvanced.entity.AppUserRole;
import com.example.springsecuritymysqladvanced.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	public void initUsers(){
		AppUser admin=new AppUser();
		admin.setUsername("Admin");
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setEmail("xin.gu1707@gmail.com");
		admin.setAppUserRole(AppUserRole.ADMIN);
		admin.setEnabled(false);
		admin.setLocked(false);

		appUserRepository.save(admin);

		AppUser user1=new AppUser();
		user1.setUsername("user");
		user1.setPassword(passwordEncoder.encode("user"));
		user1.setEmail("user1@gmail.com");
		user1.setAppUserRole(AppUserRole.USER);
		user1.setEnabled(false);
		user1.setLocked(false);
		appUserRepository.save(user1);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
