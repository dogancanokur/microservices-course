package net.okur.gatewayservice.service;

import com.google.gson.JsonElement;

import java.util.List;

/**
 * @author dogancan.okur
 * 5.12.2022 01:30
 */
public interface IProductService {
    JsonElement saveProduct(JsonElement requestBody);

    void deleteProduct(Long productId);

    List<JsonElement> getAllProducts();
}
