package com.ylcinyakup.spa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ylcinyakup.spa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByFirstname(String firstname);

	User findByLastname(String lastname);

	List<User> findAll();
}
