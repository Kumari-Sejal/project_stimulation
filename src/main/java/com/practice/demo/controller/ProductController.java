package com.practice.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.practice.demo.Product;
import com.practice.demo.repository.ProductRepo;

@Controller
@Component
public class ProductController {

	@Autowired
	ProductRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
		//System.out.println("Product Details");
	}
		
	/*@RequestMapping("/addProduct")
	public ModelAndView getProduct(@RequestParam int id)
	{
		ModelAndView mv=new ModelAndView("showProduct.jsp");
		//Product product =repo.findById(id).orElse(new Product());	
		Product product =repo.findById(id).orElse(new Product());

	    mv.addObject(product);
		repo.save(product);
		return mv;
	}*/
	
	@RequestMapping("/Products")
	@ResponseBody
	public List<Product> getProducts()
	{
		return repo.findAll();
	}

	
	@RequestMapping("/Product/{id}")
	@ResponseBody
	public Optional<Product> getProduct(@PathVariable("id") int id)
	{
		return repo.findById(id);
	}

	
}
