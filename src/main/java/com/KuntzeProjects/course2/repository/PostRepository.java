package com.KuntzeProjects.course2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.KuntzeProjects.course2.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
