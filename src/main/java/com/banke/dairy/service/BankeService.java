package com.banke.dairy.service;

import java.util.List;

import com.banke.dairy.exception.BankeException;

public interface BankeService {
	public List<String> findAllProducts() throws BankeException;
}
