package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner createAdmin(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (customerRepository.findByEmail("admin@example.com").isEmpty()) {
				Customer admin = new Customer();
				admin.setFirstName("Admin");
				admin.setLastName("User");
				admin.setEmail("admin@example.com");
				admin.setPassword(passwordEncoder.encode("admin123"));
				admin.setAddress("Admin HQ");
				admin.setRole("ROLE_ADMIN");
				customerRepository.save(admin);
				System.out.println("✅ Admin user created with full details.");
			} else {
				System.out.println("ℹ️ Admin already exists.");
			}
		};
	}

}
