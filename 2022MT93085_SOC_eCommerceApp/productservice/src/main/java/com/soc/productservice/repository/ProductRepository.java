package com.soc.productservice.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.soc.productservice.model.Product;
public interface ProductRepository extends JpaRepository<Product, String>
{
	List<Product> findByProductNameContaining(@Param("productName") String productName);
}
