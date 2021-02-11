package com.KuntzeProjects.course2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KuntzeProjects.course2.domain.User;
import com.KuntzeProjects.course2.dto.UserDTO;
import com.KuntzeProjects.course2.repository.UserRepository;
import com.KuntzeProjects.course2.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> u = repository.findById(id);
		return u.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
	}
	
	public User insert(User u) {
		return repository.insert(u);
	}

	public User fromDTO(UserDTO u) {
		return new User(u.getId(), u.getName(), u.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User u) {
		User newObj = findById(u.getId()); //É o objeto original do banco de dados!
		updateData(newObj, u);
		return repository.save(newObj);
	}

	private void updateData(User newObj, User u) {
		newObj.setId(u.getId());
		newObj.setName(u.getName());
		newObj.setEmail(u.getEmail());
	}
}
