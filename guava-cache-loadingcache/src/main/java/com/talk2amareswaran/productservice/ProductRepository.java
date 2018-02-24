package com.talk2amareswaran.productservice;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

	private List<Product> productList;

	@PostConstruct
	public void initializeProduct() {
		if (productList == null)
			productList = new ArrayList<>();

		Product product1 = new Product();
		product1.setId(1);
		product1.setName("HP - Laptop");
		product1.setPrice(38450.00d);
		productList.add(product1);

		Product product2 = new Product();
		product2.setId(2);
		product2.setName("Dell - Laptop");
		product2.setPrice(45102.00d);
		productList.add(product2);

	}

	public List<Product> getProducts() {
		return productList;
	}


	public boolean isProductExists(Product product) {
		return productList.contains(product);
	}

	public void updateProduct(Product product) {
		productList.remove(product);
		productList.add(product);
	}

	public Product getProductById(String key) {
		for(Product p:productList) {
			if(p.getId()==Integer.parseInt(key)) {
				return p;
			}
		}
		return null;
	}

}
