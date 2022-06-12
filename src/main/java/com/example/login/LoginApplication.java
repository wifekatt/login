package com.example.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.login.entity.Admin;
import com.example.login.repository.AdminRepository;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootApplication
public class LoginApplication {

	@Autowired
    private AdminRepository repository;
	
	@PostConstruct
    public void initAdmins() {
        List<Admin> Admins = Stream.of(
                new Admin("ivy", "1234", 10),
                new Admin("user1", "pwd1", 11),
                new Admin("user2", "pwd2", 12),
                new Admin("user3", "pwd3", 13)
        ).collect(Collectors.toList());
        repository.saveAll(Admins);
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

}
