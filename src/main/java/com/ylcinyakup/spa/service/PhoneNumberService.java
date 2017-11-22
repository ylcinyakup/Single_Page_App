package com.ylcinyakup.spa.service;

import java.util.List;

import com.ylcinyakup.spa.model.PhoneNumber;
import com.ylcinyakup.spa.model.User;

public interface PhoneNumberService {

	List<PhoneNumber> findAll();

	void save(PhoneNumber phoneNumber);

	List<PhoneNumber> findByUser(User user);

	PhoneNumber findOne(Long id);

	void delete(Long id);

	void deleteAll();

}
