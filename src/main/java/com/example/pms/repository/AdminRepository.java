package com.example.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pms.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin,String>{

}