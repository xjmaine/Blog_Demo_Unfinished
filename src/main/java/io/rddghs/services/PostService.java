package io.rddghs.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.rddghs.models.Posts;


public interface PostService{
	List<Posts> findAll();
	List<Posts> findLatest5();
	Posts findById(Long id);
	Posts create(Posts post);
	Posts edit(Posts post);
	void deleteById(Long id);
	

}
