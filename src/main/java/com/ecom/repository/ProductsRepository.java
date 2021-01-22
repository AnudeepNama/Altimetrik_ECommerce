package com.ecom.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecom.dal.ProductEntity;

public interface ProductsRepository extends CrudRepository<ProductEntity, Integer>{

}
