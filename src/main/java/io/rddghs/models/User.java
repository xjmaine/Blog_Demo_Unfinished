package io.rddghs.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length =30, unique = true)
	private String userName;
	
	@Column(length =60)
	private String passwordHash;
	
	@Column(length =100)
	private String fullName;
	
	@OneToMany(mappedBy ="author")
	private Set<Posts> posts = new HashSet<>();
	
	public User(Long id, String username, String passwordHash) {
	
		this.id = id;
		this.userName = username;
		this.passwordHash = passwordHash;
	}
	
	
	public Set<Posts> getPosts() {
		return posts;
	}
	
	public void setPosts(Set<Posts> posts) {
		this.posts = posts;
	}

	
}
