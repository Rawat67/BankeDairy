package com.banke.dairy.service;

import com.banke.dairy.dto.AdminDTO;
import com.banke.dairy.exception.BankeException;

public interface AdminService {
	
	public String registerAdmin(AdminDTO admin) throws BankeException;
	public AdminDTO authenticateAdmin(String emailId, String password) throws BankeException;
	
}
