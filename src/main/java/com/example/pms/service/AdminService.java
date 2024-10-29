package com.example.pms.service;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.pms.entity.Admin;
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
		
			
			Admin admin = adminRepository.save(adminMapper.mapToAdmin(adminRequest,new Admin()));
			return adminMapper.mapToAdminResponse(admin);
		}

		
		

}
