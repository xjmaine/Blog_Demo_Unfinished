package io.rddghs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.rddghs.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
