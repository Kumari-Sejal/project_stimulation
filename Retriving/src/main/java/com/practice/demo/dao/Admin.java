package com.practice.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.demo.data.Product;

@FeignClient(name="part1",url="localhost:8082")
public interface Admin {

	@GetMapping("/database/id/{i}")
	public Product retrieveExchangeValue(@PathVariable("i") Integer id);


	@RequestMapping("/Product/{id}")
	@ResponseBody
	public Optional<Product> getProduct(@PathVariable("id") int id);

	@RequestMapping("/Products")
	@ResponseBody
	public List<Product> getProducts();

	@RequestMapping("/Products/add/item")
	@ResponseBody
	public void addItem(int id, String name, double price);

	@RequestMapping("/Products/edit/item")
	@ResponseBody

	public String editItem(Integer id, String name, double price);



}
