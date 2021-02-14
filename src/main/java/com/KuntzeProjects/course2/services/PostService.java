package com.KuntzeProjects.course2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KuntzeProjects.course2.domain.Post;
import com.KuntzeProjects.course2.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> p = repository.findById(id);
		return p.get();
	}
	
	public List<Post> findAll(){
		return repository.findAll();
	}
	
	public List<Post> findByTitle(String text){
		return repository.findByTitleContainingIgnoreCase(text);
	}
}
