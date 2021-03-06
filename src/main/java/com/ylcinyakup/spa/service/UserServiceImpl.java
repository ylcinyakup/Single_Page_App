package com.ylcinyakup.spa.service;

import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylcinyakup.spa.model.User;
import com.ylcinyakup.spa.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByFirstname(String firstname) {
		return userRepository.findByFirstname(firstname);
	}

	@Override
	public User findByLastname(String lastname) {
		return userRepository.findByLastname(lastname);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@Override
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
