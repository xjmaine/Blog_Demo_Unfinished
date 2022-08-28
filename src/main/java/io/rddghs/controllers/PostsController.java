package io.rddghs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.rddghs.models.Posts;
import io.rddghs.services.NotificationService;
import io.rddghs.services.PostServiceImpl;

@Controller
public class PostsController {
	
	@Autowired
	private PostServiceImpl service;
	
	@Autowired
	private NotificationService notify;
	
	@RequestMapping("/posts/view/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		Posts post = service.findById(id);
		if(post == null) {
			notify.addErrorMessage("Post not found #" + id);
			return "redirect:/";
		}
		model.addAttribute("post", post);
		
		return "posts/view";
	}

}
