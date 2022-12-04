package net.okur.gatewayservice.controller;

import com.google.gson.JsonElement;
import net.okur.gatewayservice.service.IProductService;
import net.okur.gatewayservice.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author dogancan.okur
 * 5.12.2022 02:06
 */
@RestController
@RequestMapping("gateway/product")
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody JsonElement product) {

        return ResponseEntity.ok(productService.saveProduct(product));

    }

    @GetMapping
    public ResponseEntity<?> getAllProduct() {

        return ResponseEntity.ok(productService.getAllProducts());

    }

    @DeleteMapping("{productId}")
    public ResponseEntity<?> saveProduct(@PathVariable Long productId) {

        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
