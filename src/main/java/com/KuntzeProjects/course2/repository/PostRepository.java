package com.KuntzeProjects.course2.repository;

import java.util.List;
import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.KuntzeProjects.course2.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	List<Post> findByTitleContainingIgnoreCase(String title);
	
	@Query(" { 'title': { $regex: ?0, $options: 'i' } } ")
	List<Post> searchTitle(String text);
	
	@Query("{ $and : [ {date: {$gte:?1}} , {date: {$lte:?2}} , {$or:[{'title': { $regex: ?0, $options: 'i' }} , {'body': { $regex: ?0, $options: 'i' }}, {'comments.text': { $regex: ?0, $options: 'i' }}]} ] }")
	List<Post> completeSearch(String text, Date minDate, Date maxDate);
}
