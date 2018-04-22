package com.company.shop.persistance;

import java.util.ArrayList;
import java.util.List;

import com.company.shop.model.ProductDto;

public class ProductDao {

	public List<ProductDto> queryAvailableProducts() {
		List<ProductDto> availableProducts = new ArrayList<>();
		
		ProductDto product1 = new ProductDto();
		product1.setId(1212121212);
		product1.setLabel("R2D2");
		product1.setDescription("Howse cleaning robot.");
		
		ProductDto product2 = new ProductDto();
		product2.setId(1313131313);
		product2.setLabel("Night Guardian");
		product2.setDescription("Flying drone with infrared vision.");
		
		ProductDto product3 = new ProductDto();
		product3.setId(1001001001);
		product3.setLabel("Little Joe");
		product3.setDescription("Nanotechnology super small humanoid robot.");
		
		ProductDto product4 = new ProductDto();
		product4.setId(1001001002);
		product4.setLabel("Nimbus 2000");
		product4.setDescription("Released in 1991, it was, at the time, the fastest broomstick in production.");
		
		ProductDto product5 = new ProductDto();
		product5.setId(1001001003);
		product5.setLabel("Polyjuice Potion");
		product5.setDescription("Polyjuice Potion is a potion that allows the drinker to assume the form of someone else.");
		
		ProductDto product6 = new ProductDto();
		product6.setId(1001001004);
		product6.setLabel("Sorting Hat");
		product6.setDescription("Enchanted hat that once belonged to Godric Gryffindor.");
		
		availableProducts.add(product1);
		availableProducts.add(product2);
		availableProducts.add(product3);
		availableProducts.add(product4);
		availableProducts.add(product5);
		availableProducts.add(product6);
		
		return availableProducts;
	}
	
}
