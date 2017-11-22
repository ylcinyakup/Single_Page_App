package com.ylcinyakup.spa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ylcinyakup.spa.model.PhoneNumber;
import com.ylcinyakup.spa.service.PhoneNumberService;
import com.ylcinyakup.spa.service.UserService;


@RestController
@RequestMapping(value = "/users/{userId}/phoneNumbers", produces = MediaType.APPLICATION_JSON_VALUE)
public class PhoneNumberController {

	@Autowired
	private UserService userService;

	@Autowired
	private PhoneNumberService phoneNumberService;

	// users/1/phoneNumbers 1. userın telefonlarını dönderir...
	@GetMapping
	public ResponseEntity<List<PhoneNumber>> userPhoneNumbers(@PathVariable Long userId) {
		return new ResponseEntity<List<PhoneNumber>>(phoneNumberService.findByUser(userService.findOne(userId)),
				HttpStatus.OK);
	}

	// users/1/phoneNumbers 1. usera yeni bir numara ekler
	@PostMapping
	public ResponseEntity<List<PhoneNumber>> createPhoneNumber(@PathVariable Long userId,
			@RequestBody PhoneNumber phoneNumber) {
		System.out.println(phoneNumber);
		phoneNumber.setUser(userService.findOne(userId));
		phoneNumberService.save(phoneNumber);
		return new ResponseEntity<List<PhoneNumber>>(phoneNumberService.findByUser(userService.findOne(userId)),
				HttpStatus.OK);
	}

	// users/1/phoneNumbers/1 1. userın 1. numarasını siler
	@DeleteMapping(value = "/{phnId}")
	public ResponseEntity<List<PhoneNumber>> deleteAddress(@PathVariable Long phnId, @PathVariable Long userId) {
		phoneNumberService.delete(phnId);
		return new ResponseEntity<List<PhoneNumber>>(phoneNumberService.findByUser(userService.findOne(userId)),
				HttpStatus.OK);
	}

	// users/1/phoneNumbers/1 1. userın 1. numarasını günceller
	@PutMapping(value = "/{phnId}")
	public ResponseEntity<List<PhoneNumber>> updatePhoneNumberById(@PathVariable Long phnId, @PathVariable Long userId,
			@RequestBody PhoneNumber phoneNumber) {
		PhoneNumber currentPhoneNumber = phoneNumberService.findOne(phnId);
		currentPhoneNumber.setPhoneNumber(phoneNumber.getPhoneNumber());
		phoneNumberService.save(currentPhoneNumber);

		return new ResponseEntity<List<PhoneNumber>>(phoneNumberService.findByUser(userService.findOne(userId)),
				HttpStatus.OK);
	}

	// users/1/phoneNumbers/1 1. userın 1. numarasını geriye dönderir
	@GetMapping(value = "/{phnId}")
	public ResponseEntity<PhoneNumber> userPhoneNumber(@PathVariable Long userId, @PathVariable Long phnId) {
		return new ResponseEntity<PhoneNumber>(phoneNumberService.findOne(phnId), HttpStatus.OK);
	}

}
