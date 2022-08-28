package io.rddghs.controllers;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.rddghs.models.Posts;
import io.rddghs.services.PostServiceImpl;


@Controller
public class HomeController {
	
	@Autowired
	private PostServiceImpl service;
	
	@RequestMapping("/")
	public String indexPage(Model model) {
		List<Posts> latest5Posts = service.findLatest5();
		model.addAttribute("latest5posts", latest5Posts);
		
		List<Posts> latest3Posts = latest5Posts.stream()
				.limit(3)
				.collect(Collectors.toList());
		model.addAttribute("latest3posts", latest3Posts);
		
		return "index";
	}


}
