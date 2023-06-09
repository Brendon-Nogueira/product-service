package br.edu.univas.topicos.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univas.topicos.product.dto.ProductDTO;
import br.edu.univas.topicos.product.entities.ProductEntity;
import br.edu.univas.topicos.product.repository.ProductRepository;
import br.edu.univas.topicos.product.support.ObjectNotFoundException;



@Service
public class ProductService {

	
	private ProductRepository repo;
	
	@Autowired
	public ProductService(ProductRepository repo) {
		this.repo = repo;
	}

	public List<ProductDTO> findAll() {
		return repo.findAll()
			.stream()
			.map(p -> new ProductDTO(p))
			.collect(Collectors.toList());
	}
	
	public List<ProductDTO> findAllActive() { 
		return repo.findByActive(true)
			.stream()
			.map(p -> new ProductDTO(p))
			.collect(Collectors.toList());
	}

	public ProductDTO findById(Integer code) {
		Optional<ProductEntity> obj = repo.findById(code);
		ProductEntity entity = obj.orElseThrow(
			() -> new ObjectNotFoundException("Product " + code + " not found"));
		return new ProductDTO(entity);
	}
}