package com.example.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByAdminName(String adminName);
}
