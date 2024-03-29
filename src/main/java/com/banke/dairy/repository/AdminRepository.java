package com.banke.dairy.repository;

import org.springframework.data.repository.CrudRepository;

import com.banke.dairy.entity.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
	public Admin findByEmailId(String emailId);
	public Admin findByPhone(String phone);
}
