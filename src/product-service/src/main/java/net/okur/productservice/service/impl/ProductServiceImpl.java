package net.okur.productservice.service.impl;

import net.okur.productservice.model.Product;
import net.okur.productservice.repository.ProductRepository;
import net.okur.productservice.service.ProductConnectionServiceImpl;
import net.okur.productservice.service.ProductService;
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
    private final ProductConnectionServiceImpl productConnectionService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductConnectionServiceImpl productConnectionService) {
        this.productRepository = productRepository;
        this.productConnectionService = productConnectionService;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
//        product.setCreateTime(LocalDateTime.now());
        product = productRepository.save(product);

        // send to queue - message & with broker topology
        productConnectionService.sendToQueue(product);

        // send direct - request driven arch
//        productConnectionService.sendTransaction(product);

        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        Product dbProduct = productRepository.findById(product.getId()).orElse(null);
        if (dbProduct == null) {
            // todo ...
            return product;
        }

//        product.setCreateTime(dbProduct.getCreateTime());
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
