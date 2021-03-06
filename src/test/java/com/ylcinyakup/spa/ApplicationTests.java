package com.ylcinyakup.spa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ylcinyakup.spa.model.Address;
import com.ylcinyakup.spa.model.PhoneNumber;
import com.ylcinyakup.spa.model.User;
import com.ylcinyakup.spa.service.AddressService;
import com.ylcinyakup.spa.service.PhoneNumberService;
import com.ylcinyakup.spa.service.UserService;
import com.ylcinyakup.spa.test.MyTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	private double value1, value2;

	@Autowired
	private MyTest myTest;

	@Autowired
	private UserService userService;

	@Autowired
	private PhoneNumberService phoneNumberService;

	@Autowired
	private AddressService addressService;

	@Before
	public void setUp() {
		value1 = 2.0;
		value2 = 3.0;
	}

	@Test
	public void contextLoads() {

		User user = new User("deneme", "deneme", "deneme@gmail.com");

		Set adresler = new LinkedHashSet<Address>() {
			{
				add(new Address("birinci"));
				add(new Address("ikinci"));
				add(new Address("ücüncü"));
			}
		};
		user.setAddresses(adresler);

		Set phoneNumbers = new LinkedHashSet<PhoneNumber>() {
			{
				add(new PhoneNumber("birnumara"));
				add(new PhoneNumber("ikinumara"));
				add(new PhoneNumber("ucnumara"));
			}
		};
		user.setPhoneNumbers(phoneNumbers);

		userService.save(user);

		List<PhoneNumber> phrs = phoneNumberService.findByUser(userService.findByFirstname("deneme"));
		assertThat("birnumara").isEqualTo(phrs.iterator().next().getPhoneNumber());

	}

	@Test(timeout = 1000)
	public void jUnitDeneme() {

		assertThat(4.0).isEqualTo(myTest.carp(2.0, 2.0));

		assertEquals(4.0, myTest.kalan(13.0, 8.0), 1);

		assertTrue("cevap doğru", myTest.carp(2.0, 4.0) == 8.0);
		assertFalse("islem false dondu", myTest.carp(2.0, 4.0) == 4.0);

		int[] sayi = { 2, 1, 5, 3, 6 };
		int[] sayi2 = { 2, 1, 5, 3, 6 };
		assertArrayEquals("diziler eşleşiyor", sayi, sayi2);

		assertEquals("tamamdır", "Hello world", myTest.getMessage());

		Set<Double> sayilar = new LinkedHashSet<Double>();
		sayilar.add(5.0);
		sayilar.add(3.0);
		assertThat(5.0).isGreaterThan(3.0);
		assertThat(5.0).isIn(sayilar);
		assertThat(5.0).isPositive();

	}

}
