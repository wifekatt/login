package com.example.login.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.login.entity.Admin;
import com.example.login.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomAdminDetailsService implements UserDetailsService {
	 @Autowired
	    private AdminRepository repository;

	    @Override
	    public UserDetails loadUserByUsername(String adminName) throws UsernameNotFoundException {
	        Admin admin = repository.findByAdminName(adminName);
	        return new org.springframework.security.core.userdetails.User(admin.getAdminName(), admin.getAdminPassword(), new ArrayList<>());
	    }

}
