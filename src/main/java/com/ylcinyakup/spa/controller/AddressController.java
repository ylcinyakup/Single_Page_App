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

import com.ylcinyakup.spa.model.Address;
import com.ylcinyakup.spa.service.AddressService;
import com.ylcinyakup.spa.service.UserService;


@RestController
@RequestMapping(value = "/users/{userId}/addresses", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressController {

	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addressService;

	// users/1/addresses 1. userın adreslerini dönderir...
	@GetMapping
	public ResponseEntity<List<Address>> userAddresses(@PathVariable Long userId) {
		return new ResponseEntity<List<Address>>(addressService.findByUser(userService.findOne(userId)), HttpStatus.OK);
	}

	// users/1/addresses 1. usera adres ekler
	@PostMapping
	public ResponseEntity<List<Address>> createAddress(@PathVariable Long userId, @RequestBody Address address) {
		address.setUser(userService.findOne(userId));
		addressService.save(address);
		return new ResponseEntity<List<Address>>(addressService.findByUser(userService.findOne(userId)), HttpStatus.OK);
	}
	
	// users/1/addresses/1 1. user ın 1 id li adresini siler
	@DeleteMapping(value = "/{adresId}")
	public ResponseEntity<List<Address>> deleteAddress(@PathVariable Long adresId, @PathVariable Long userId) {
		addressService.delete(adresId);
		return new ResponseEntity<List<Address>>(addressService.findByUser(userService.findOne(userId)), HttpStatus.OK);
	}
	// users/1/address/1 1. user'ın 1. adresini günceller
	@PutMapping(value = "/{adresId}")
	public ResponseEntity<List<Address>> updateAddressById(@PathVariable Long adresId, @PathVariable Long userId,
			@RequestBody Address address) {
		Address currentAddress = addressService.findOne(adresId);
		currentAddress.setAddress(address.getAddress());
		addressService.save(currentAddress);

		return new ResponseEntity<List<Address>>(addressService.findByUser(userService.findOne(userId)), HttpStatus.OK);
	}

	// users/1/addresses/1 1.. userın 1.adresini geriye gönderir
	@GetMapping(value = "/{adresId}")
	public ResponseEntity<Address> userAddress(@PathVariable Long userId, @PathVariable Long adresId) {
		return new ResponseEntity<Address>(addressService.findOne(adresId), HttpStatus.OK);
	}

}
