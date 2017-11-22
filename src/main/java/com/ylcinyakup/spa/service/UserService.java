package com.ylcinyakup.spa.service;

import java.util.List;

import com.ylcinyakup.spa.model.User;


public interface UserService {

	User findByFirstname(String firstname);

	User findByLastname(String lastname);

	void deleteAll();

	void delete(Long id);

	User findOne(Long id);

	void save(User user);

	List<User> findAll();

}
