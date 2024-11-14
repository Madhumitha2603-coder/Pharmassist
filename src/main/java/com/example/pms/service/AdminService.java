package com.example.pms.service;



	import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

	import com.example.pms.entity.Admin;
import com.example.pms.exception.AdminNotFoundByIdException;
import com.example.pms.mapper.AdminMapper;
	import com.example.pms.repository.AdminRepository;
	import com.example.pms.requestdtos.AdminRequest;
	import com.example.pms.responsedtos.AdminResponse;


	@Service

		public class AdminService {
			private final AdminRepository adminRepository;
			private final AdminMapper adminMapper;
			private final PasswordEncoder passwordEncoder;
			
			
			public AdminService(AdminRepository adminRepository, AdminMapper adminMapper,
					PasswordEncoder passwordEncoder) {
				super();
				this.adminRepository = adminRepository;
				this.adminMapper = adminMapper;
				this.passwordEncoder = passwordEncoder;
			}

			public AdminResponse addAdmin(AdminRequest adminRequest) {
				
				Admin admin=adminMapper.mapToAdmin(adminRequest,new Admin());
				admin.setAdminPassword(passwordEncoder.encode(admin.getAdminPassword()));
				Admin admin1 = adminRepository.save(admin);
				return adminMapper.mapToAdminResponse(admin1);
			}
	
			public AdminResponse findAdmin(String adminId) {

			      return  adminRepository.findById(adminId)
			                             .map(adminMapper::mapToAdminResponse)
			                             .orElseThrow(() -> new AdminNotFoundByIdException("Failed to find admin"));
				}
			public List<AdminResponse> findAllAdmins() {
			     return	adminRepository.findAll()
		                               .stream()
		                               .map(adminMapper::mapToAdminResponse)
		                               .toList();		
			}

			public AdminResponse updateAdmin(AdminRequest adminRequest, String adminId) {
				
				return adminRepository.findById(adminId)
		                .map(exAdmin -> {
		       	          adminMapper.mapToAdmin(adminRequest, exAdmin);
		       	          return adminRepository.save(exAdmin);
		                })
		                .map(adminMapper::mapToAdminResponse)
		                .orElseThrow(() -> new AdminNotFoundByIdException("Failed to update admin"));
		}


}
