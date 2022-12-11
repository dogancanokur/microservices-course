package net.okur.productservice.controller;

import io.swagger.annotations.ApiOperation;
import net.okur.productservice.model.Product;
import net.okur.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author dogancan.okur
 * 8.10.2022 04:24
 */

@RestController
@RequestMapping("api/v1/product") // pre-path
@ApiOperation(value = "Product Rest Controller")
public class ProductRestController {
    private final ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ApiOperation(value = "Get All Product")
    public ResponseEntity<?> getAllProduct() {
        List<Product> productList = productService.findAllProducts();
        return ResponseEntity.ok(productList);
    }

    @PostMapping // =>  api/v1/product
    @ApiOperation(value = "Save Product", httpMethod = "POST")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @PutMapping // =>  api/v1/product
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
    }

    @DeleteMapping("{productId}") // =>  api/v1/product
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        productService.deleteProductById(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("project-test")
    public String testEndPoint() {
        int times = 10000;

        String result = "request start at " + LocalDateTime.now().toString() + " with " + times + " times";

        for (int i = 0; i < times; i++) {
            Product product = new Product();
            String name = UUID.randomUUID().toString();
            product.setName(name);
            product.setProductCode("code_" + name);
            double random = Math.random();
            product.setPrice(random * 20);
            product.setQuantity((int) (random * 300));
            product.setCreatedUserId(1L);
            productService.saveProduct(product);
        }
        return result;
    }
}
