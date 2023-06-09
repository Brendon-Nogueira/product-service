package br.edu.univas.topicos.product.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.topicos.product.dto.ProductDTO;
import br.edu.univas.topicos.product.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<ProductDTO> getAllProducts() {
		return service.findAll();
	}

	@GetMapping("/{code}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer code) {
		ProductDTO dto = service.findById(code);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping("/active")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductDTO> getAllProductsActive() {
		return service.findAllActive();
	}

}
