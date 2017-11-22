package com.ylcinyakup.spa;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ylcinyakup.spa.model.Address;
import com.ylcinyakup.spa.model.PhoneNumber;
import com.ylcinyakup.spa.model.User;
import com.ylcinyakup.spa.repository.UserRepository;
import com.ylcinyakup.spa.service.UserService;

/**
 * 
 * @author yakup
 * 
 */

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// default olarak 2 user oluşturması için burası var başka bir amaç içermiyor
	@Override
	public void run(String... args) throws Exception {

		User user1 = new User("asdqwe", "asdqwe", "asdqwe");
		User user2 = new User("yakup", "yalcin", "ylcinyakup@gmail.com");
		Set adresler = new LinkedHashSet<Address>() {
			{
				add(new Address("adres1"));
				add(new Address("adres2"));
				add(new Address("adres3"));
			}
		};
		Set adresler2 = new LinkedHashSet<Address>() {
			{
				add(new Address("adrasd"));
				add(new Address("asd"));
				add(new Address("qwe"));
			}
		};
		user1.setAddresses(adresler);
		user2.setAddresses(adresler2);

		Set phoneNumbers = new LinkedHashSet<PhoneNumber>() {
			{
				add(new PhoneNumber("numara1"));
				add(new PhoneNumber("numara2"));
				add(new PhoneNumber("numara3"));
			}
		};
		Set phoneNumbers2 = new LinkedHashSet<PhoneNumber>() {
			{
				add(new PhoneNumber("123123"));
				add(new PhoneNumber("123123"));
				add(new PhoneNumber("1231"));
			}
		};
		user1.setPhoneNumbers(phoneNumbers);
		user2.setPhoneNumbers(phoneNumbers2);

		userService.save(user1);
		userService.save(user2);

	}
}
