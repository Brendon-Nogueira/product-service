package br.edu.univas.topicos.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.univas.topicos.product.entities.ProductEntity;
import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
	public List<ProductEntity>findByActive(Boolean active);
	
}