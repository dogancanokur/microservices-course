package net.okur.productservice.service;

import net.okur.productservice.model.Product;

import java.util.List;

/**
 * @author dogancan.okur
 * 8.10.2022 04:10
 */

public interface ProductService {
    Product saveProduct(Product product);

    Product updateProduct(Product product);

    void deleteProductById(Long id);

    List<Product> findAllProducts();
}
