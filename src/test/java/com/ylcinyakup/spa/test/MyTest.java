package com.ylcinyakup.spa.test;

import org.springframework.stereotype.Service;

@Service
public class MyTest {
	
	public double topla(double a, double b) {
		return a + b;
	}

	public double cikart(double a, double b) {
		return a - b;
	}

	public double carp(double a, double b) {
		return a * b;
	}

	public double bol(double a, double b) {
		return a / b;
	}

	public double kalan(double a, double b) {
		return a % b;
	}
	
	public String getMessage() {
		return "Hello world";
	}

}
