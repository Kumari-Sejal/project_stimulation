package com.practice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.practice.demo.Product;

@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
