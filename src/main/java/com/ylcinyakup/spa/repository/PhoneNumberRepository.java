package com.ylcinyakup.spa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ylcinyakup.spa.model.PhoneNumber;
import com.ylcinyakup.spa.model.User;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {

	PhoneNumber findByPhoneNumber(String phoneNumber);

	List<PhoneNumber> findAll();

	List<PhoneNumber> findByUser(User user);

	PhoneNumber findOne(Long id);

	void delete(Long id);

	void deleteAll();
}
