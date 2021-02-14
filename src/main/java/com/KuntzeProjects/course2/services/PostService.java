package com.KuntzeProjects.course2.services;

import java.util.Date;
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
		return repository.searchTitle(text);
	}
	
	public List<Post> completeSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24*60*60*1000);
		return repository.completeSearch(text, minDate, maxDate);
	}
}
