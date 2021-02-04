package com.KuntzeProjects.course2.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.KuntzeProjects.course2.domain.User;
import com.KuntzeProjects.course2.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
		
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User u1 = new User(null, "Maria Brown", "maria@email.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
	}

}
