package com.KuntzeProjects.course2.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.KuntzeProjects.course2.domain.User;
import com.KuntzeProjects.course2.dto.UserDTO;
import com.KuntzeProjects.course2.services.UserService;

@RestController
@RequestMapping(value="/users") //Caminho do End-Point
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET) //OU "@GetMapping"
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); 
		return ResponseEntity.ok().body(listDto);
	}
}
