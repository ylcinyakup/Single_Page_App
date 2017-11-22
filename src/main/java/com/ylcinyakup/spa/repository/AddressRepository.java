package com.ylcinyakup.spa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ylcinyakup.spa.model.Address;
import com.ylcinyakup.spa.model.User;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findAll();

	List<Address> findByUser(User user);

	Address findOne(Long id);

	void delete(Long id);

	void deleteAll();

}
