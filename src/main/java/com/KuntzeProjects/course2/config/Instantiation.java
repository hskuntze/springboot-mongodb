package com.KuntzeProjects.course2.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.KuntzeProjects.course2.domain.Post;
import com.KuntzeProjects.course2.domain.User;
import com.KuntzeProjects.course2.dto.AuthorDTO;
import com.KuntzeProjects.course2.repository.PostRepository;
import com.KuntzeProjects.course2.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
		
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User u1 = new User(null, "Maria Brown", "maria@email.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		
		Post p1 = new Post(null, sdf.parse("09/02/2019"), "Lorem ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", new AuthorDTO(u1));	
		Post p2 = new Post(null, sdf.parse("19/09/2020"), "Dolor", "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.", new AuthorDTO(u3));
		Post p3 = new Post(null, sdf.parse("28/01/2020"), "Excepteur", "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", new AuthorDTO(u1));
		
		postRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}
