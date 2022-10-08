package com.banke.dairy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.banke.dairy.dto.AdminDTO;
import com.banke.dairy.service.AdminService;

@RestController
@CrossOrigin
@RequestMapping(value = "/banke")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private Environment environment;
	
	@PostMapping(value = "/register")
	public ResponseEntity<String> registerBuyer(@RequestBody AdminDTO admin){
		try {
			String name= adminService.registerAdmin(admin);
			String message= environment.getProperty("AdminController.CONGRATULATION ")+name+" "+
					environment.getProperty("AdminController.REGISTRATION_SUCCESS");
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
		
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<AdminDTO> loginBuyer(@RequestBody AdminDTO admin){
		try {
			AdminDTO adminDTO= adminService.authenticateAdmin(admin.getEmailId(), admin.getPassword());
			return new ResponseEntity<AdminDTO>(adminDTO, HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}
	
}
