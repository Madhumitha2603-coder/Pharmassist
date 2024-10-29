package com.example.pms.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.pms.entity.Admin;
import com.example.pms.exception.AdminNotFoundByIdException;
import com.example.pms.exception.AdminNotFoundException;
import com.example.pms.mapper.AdminMapper;
import com.example.pms.repository.AdminRepository;
import com.example.pms.request.AdminRequest;
import com.example.pms.response.AdminResponse;

import jakarta.validation.Valid;

	@Service
	public class AdminService {
		
		private final AdminRepository adminRepository;
		private final AdminMapper adminMapper;
		
		public AdminService(AdminRepository adminRepository, AdminMapper adminMapper) {
			super();
			this.adminRepository = adminRepository;
			this.adminMapper = adminMapper;
		}
		
		public AdminResponse saveAdmin(AdminRequest adminRequest) {
		    return Optional.of(adminRequest)
		        .map(request -> adminMapper.mapToAdmin(request, new Admin()))
		        .map(adminRepository::save)
		        .map(adminMapper::mapToAdminResponse)
		        .orElseThrow(() -> new RuntimeException("Failed to save admin"));
		}

		public AdminResponse findAdminById(String adminId) {
			 return adminRepository.findById(adminId)
				        .map(adminMapper::mapToAdminResponse)
				        .orElseThrow(() -> new AdminNotFoundByIdException("Failed to find user"));
			
		}
			
		public AdminResponse updateAdmin(AdminRequest adminRequest, String adminId) {
		    return adminRepository.findById(adminId)
		        .map(admin -> adminMapper.mapToAdmin(adminRequest, admin))
		        .map(adminRepository::save)
		        .map(adminMapper::mapToAdminResponse)
		        .orElseThrow(() -> new AdminNotFoundException("Failed to update the admin"));
		}
	
	
		
		

}
