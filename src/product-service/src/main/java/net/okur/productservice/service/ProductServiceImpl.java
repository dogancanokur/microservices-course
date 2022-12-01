package net.okur.productservice.service;

import net.okur.productservice.model.Product;
import net.okur.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author dogancan.okur
 * 8.10.2022 04:12
 */

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        product.setCreateTime(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product dbProduct = productRepository.findById(product.getId()).orElse(null);
        if (dbProduct == null) {
            // todo ...
            return product;
        }

        product.setCreateTime(dbProduct.getCreateTime());
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
