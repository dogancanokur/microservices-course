package net.okur.productservice.repository;

import net.okur.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dogancan.okur
 * 8.10.2022 04:05
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);

}
