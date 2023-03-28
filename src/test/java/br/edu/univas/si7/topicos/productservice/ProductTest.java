package br.edu.univas.si7.topicos.productservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


import br.edu.univas.topicos.product.controller.ProductController;
import br.edu.univas.topicos.product.entities.ProductEntity;

public class ProductTest {
ProductController controller = new ProductController();
	
	@Test
	public void testeHelloProduct() {
		ProductEntity product = controller.HelloProduct();
		assertEquals(1, product.getCode());
		assertEquals("Product v3", product.getName());
		assertEquals(2.45f, product.getPrice());
	}
	}
