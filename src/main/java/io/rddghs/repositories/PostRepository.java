package io.rddghs.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.rddghs.models.Posts;

@Repository
public interface PostRepository extends JpaRepository<Posts, Long>{
	@Query("SELECT p FROM Posts p LEFT JOIN FETCH p.author ORDER BY p.date DESC")
	List<Posts> findLatest5Posts(Pageable pageable);
}
