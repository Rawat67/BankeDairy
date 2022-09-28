package com.banke.dairy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banke.dairy.dto.AdminDTO;
import com.banke.dairy.exception.BankeException;
import com.banke.dairy.repository.AdminRepository;

@Service(value = "ddminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public String registerAdmin(AdminDTO admin) throws BankeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminDTO authenticateAdmin(String emailId, String password) throws BankeException {
		// TODO Auto-generated method stub
		return null;
	}

}
