package com.iuh.nhom05.AuthorService;

import com.iuh.nhom05.AuthorService.entities.User;
import com.iuh.nhom05.AuthorService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthorServiceApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(AuthorServiceApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		//When app run, user will be saved
		User user = User.builder()
				.username("someone")
				.password(passwordEncoder.encode("password"))
				.build();

		userRepository.save(user);
	}
}
