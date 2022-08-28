package io.rddghs.services;

import java.util.List;
import java.util.Optional;

import io.rddghs.models.User;

public interface UserService {
	List<User> findAll();
	List<User> findLatest5();
	Optional<User> findById(Long id);
	User create(User user);
	User edit(User user);
	void deleteById(Long id);
	boolean authenticate(String username, String password);
}

