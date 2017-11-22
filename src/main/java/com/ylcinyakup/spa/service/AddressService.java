package com.ylcinyakup.spa.service;

import java.util.List;

import com.ylcinyakup.spa.model.Address;
import com.ylcinyakup.spa.model.User;


public interface AddressService {
	
	List<Address> findAll();
	
	void save(Address address);
		
	List<Address> findByUser(User user);
	
	Address findOne(Long id);

	void delete(Long id);
	
	void deleteAll();
}
