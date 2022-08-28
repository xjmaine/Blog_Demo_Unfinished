package io.rddghs.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import io.rddghs.models.User;
import io.rddghs.repositories.UserRepository;

@Service
@Primary
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> findAll() {
	return this.userRepo.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
	return this.userRepo.findById(id);
	}

	@Override
	public User create(User user) {
	return this.userRepo.save(user);
	}

	@Override
	public User edit(User user) {
	return this.userRepo.save(user);
	}

	@Override
	public void deleteById(Long id) {
	this.userRepo.deleteById(id);
	} 

	@Override
	public List<User> findLatest5() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return Objects.equals(username, password);
	}
	
}
