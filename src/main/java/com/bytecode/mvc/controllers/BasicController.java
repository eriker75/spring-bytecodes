package com.bytecode.mvc.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bytecode.mvc.configuration.Pages;
import com.bytecode.mvc.models.Post;

@Controller
@RequestMapping("/hola")
public class BasicController {

	public List<Post> getPost(){
		ArrayList<Post> posts = new ArrayList<>();
		
		posts.add(new Post(1,"descripcion del post","img/post/1.jpg",new Date(),"Titulo del post 1"));
		posts.add(new Post(2,"descripcion del post","img/post/2.jpg",new Date(),"Titulo del post 2"));
		posts.add(new Post(3,"descripcion del post","img/post/3.jpg",new Date(),"Titulo del post 3"));
		posts.add(new Post(4,"descripcion del post","img/post/4.jpg",new Date(),"Titulo del post 4"));
		
		return posts;
	}
	
	@GetMapping(path= {"/saludar","/saludan"})
	public String Saludar(Model model) {
		model.addAttribute("posts",getPost());
		return "index";
	}
	
	@GetMapping(value="/model-and-view")
	public ModelAndView 
	getPostIndividual(
			@RequestParam(defaultValue="1",name="ID",required=false) int id
	) {
		ModelAndView mv = new ModelAndView(Pages.POST);
		return mv;
	}
	
}
