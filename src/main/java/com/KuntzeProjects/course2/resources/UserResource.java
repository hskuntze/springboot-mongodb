package com.KuntzeProjects.course2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.KuntzeProjects.course2.domain.User;
import com.KuntzeProjects.course2.services.UserService;

@RestController
@RequestMapping(value="/users") //Caminho do End-Point
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET) //OU "@GetMapping"
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
