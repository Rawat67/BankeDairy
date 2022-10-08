package com.banke.dairy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banke.dairy.dto.AdminDTO;
import com.banke.dairy.entity.Admin;
import com.banke.dairy.exception.BankeException;
import com.banke.dairy.repository.AdminRepository;
import com.banke.dairy.validator.AdminValidator;

@Service(value = "adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public String registerAdmin(AdminDTO admin) throws BankeException {
		if(adminRepo.findByEmailId(admin.getEmailId())!=null) {
			throw new BankeException("AdminService.EMAIL_ALREADY_EXIST");
		}
		if(adminRepo.findByPhone(admin.getPhone())!=null) {
			throw new BankeException("AdminService.PHONE_ALREADY_REGISTERED");
		}
		try {
			Admin adminEntity = AdminDTO.createAdminEntity(admin);
			adminRepo.save(adminEntity);
			return adminEntity.getName();
		}
		catch (Exception e) {
			throw new BankeException("AdminService.ERROR_OCCURED");
		}
	}

	@Override
	public AdminDTO authenticateAdmin(String emailId, String password) throws BankeException {
		// TODO Auto-generated method stub
		AdminValidator.validateEmail(emailId);
		Admin admin = adminRepo.findByEmailId(emailId);
		if(admin == null) {
			throw new BankeException("AdminService.INVALID_CREDENTIALS");
		}
		if(admin.getPassword()!=null) {
			try {
				if(admin.getPassword().equals(password)) {
					AdminDTO adminDTO  = Admin.createAdminDTO(admin);
					return adminDTO;
				}
				else {
					throw new BankeException("AdminService.INVALID_CREDENTIALS");
				}
			}
			catch(Exception e){
				throw new BankeException("AdminService.INVALID_CREDENTIALS");
			}
		}
		else {
			throw new BankeException("AdminService.INVALID_CREDENTIALS");
		}
		
	}
}
