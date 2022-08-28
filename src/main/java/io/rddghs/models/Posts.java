package io.rddghs.models;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="posts")
public class Posts {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, length = 300)
	    private String title;

	    @Lob @Column(nullable = false)
	    private String body;

	    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	    private User author;
	   
	    @Column(nullable = false)
	    private Date date = new Date();
	
	public Posts(Long id, String title, String body, User author) {

		this.id = id;
		this.title = title;
		this.body = body;
		this.author = author;
	}
	
	

}
