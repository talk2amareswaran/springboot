package com.talk2amareswaran.productservice;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProductserviceApplication {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductCacheConfig productCacheConfig;

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getProducts() {
		return productRepository.getProducts();
	}

	@RequestMapping(value = "/products", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
		if (productRepository.isProductExists(product)) {
			productRepository.updateProduct(product);
			return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("Product is not found", HttpStatus.OK);
	}
	
	@RequestMapping(value="/products/{id}" , method=RequestMethod.GET)
	public Product getProduct(@PathVariable("id") String id) throws ExecutionException {
		System.out.println(productCacheConfig.getCacheStats().toString());
		return productCacheConfig.getProduct(id);
	}

}