package com.ylcinyakup.spa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylcinyakup.spa.model.PhoneNumber;
import com.ylcinyakup.spa.model.User;
import com.ylcinyakup.spa.repository.PhoneNumberRepository;

@Service
@Transactional
public class PhoneNumberServiceImpl implements PhoneNumberService {

	@Autowired
	private PhoneNumberRepository phoneNumberRepository;

	@Override
	public List<PhoneNumber> findAll() {
		return phoneNumberRepository.findAll();
	}

	@Override
	public void save(PhoneNumber phoneNumber) {
		phoneNumberRepository.save(phoneNumber);
	}

	@Override
	public List<PhoneNumber> findByUser(User user) {
		return phoneNumberRepository.findByUser(user);
	}

	@Override
	public PhoneNumber findOne(Long id) {
		return phoneNumberRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		phoneNumberRepository.delete(id);
	}

	@Override
	public void deleteAll() {
		phoneNumberRepository.deleteAll();
	}

}
