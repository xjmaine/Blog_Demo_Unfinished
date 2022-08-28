package io.rddghs.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import io.rddghs.models.Posts;
import io.rddghs.models.User;

@Service
@Primary
public class PostServiceImpl implements PostService{
	
	
	private List<Posts> posts = new ArrayList<Posts>() {
		{
			add(new Posts(1L, "First Post", "<p>Line #1. </p> <p>Line #2</p>", null));
			add(new Posts(2L, "Second Post","Second post content:<ul><li>line 1</li><li>line 2</li></p>",
					new User(10L, "Sam", "Claude")));
			add(new Posts(3L, "Post #3", "<p>Not an interesting post</p>", 
					new User(10L, "Yelp", null)));
			add(new Posts(4L, "Post #4", "<p>Not interesting post</p>", null));
			add(new Posts(5L, "Post #5", "<p>post</p>", null));
			add(new Posts(6L, "Post #6", "<p>Another interesting post</p>", null));
		}
	};
	
	@Override
	public List<Posts> findAll(){
		return this.posts;
	}
	
	@Override
	public List <Posts> findLatest5(){
		return this.posts.stream()
				.sorted((a,b)->b.getDate() .compareTo(a.getDate()))
				.limit(5)
				.collect(Collectors.toList());
	}
	
	@Override
	public Posts findById(Long id) {
		return this.posts.stream()
				.filter(p->Objects.equals(p.getId(), id))
				.findFirst().orElse(null);
	}
	
	@Override
	public Posts create(Posts post) {
		post.setId(this.posts.stream().mapToLong(
				p->p.getId()).max().getAsLong()+1);
		this.posts.add(post);
		return post;
	}
	
	@Override
	public Posts edit(Posts post) {
		for(int i=0; i<this.posts.size(); i++) {
			if(Objects.equals(this.posts.get(i), post.getId())) {
				this.posts.set(i, post);
				return post;
			}
		}
		throw new RuntimeException("Post not found: "+post.getId());
		
	}
	
	@Override
	public void deleteById(Long id) {
		for(int i =0; i<this.posts.size(); i++) {
			if(Objects.equals(this.posts.get(i), id)) {
				this.posts.remove(i);
				return;
			}
		}
		throw new RuntimeException("Post not found: "+id);
	}

	
	
}

