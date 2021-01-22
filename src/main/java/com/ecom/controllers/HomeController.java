package com.ecom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.models.Products;
import com.ecom.service.ProductsService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private ProductsService productsService;
	
	@GetMapping(path = "/products",produces = "application/json")
	public ResponseEntity<List<Products>> getAllProducts(){
		try {
			return new ResponseEntity<>(productsService.getAllProducts(),HttpStatus.OK
					);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}
	

}
