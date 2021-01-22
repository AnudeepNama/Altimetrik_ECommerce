package com.ecom.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.dal.ProductEntity;
import com.ecom.models.Products;
import com.ecom.repository.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productRepo;
	
	public List<Products> convertToProductModels(Iterable<ProductEntity> all){
		List<Products> products = new ArrayList<>();
		for(ProductEntity each:all) {
			Products product = new Products();
			product.setpID(each.getpID());
			product.setPrice(each.getPrice());
			product.setProductName(each.getProductName());
			product.setQuantity(each.getQuantity());
			products.add(product);
		}
		return products;
	}
	
	public List<Products> getAllProducts(){
		try {
			return convertToProductModels(productRepo.findAll());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
