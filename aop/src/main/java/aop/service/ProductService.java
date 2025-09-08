package aop.service;

import org.springframework.stereotype.Service;

import aop.domain.Product;

@Service
public class ProductService {

	public Product find(String name) {
		System.out.println("finding...");
		return new Product(name);
	}

}