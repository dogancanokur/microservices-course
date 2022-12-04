package net.okur.gatewayservice.service.impl;

import com.google.gson.JsonElement;
import lombok.extern.slf4j.Slf4j;
import net.okur.gatewayservice.request.IProductServiceRequest;
import net.okur.gatewayservice.service.IProductService;
import net.okur.gatewayservice.utils.RetrofitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dogancan.okur
 * 5.12.2022 01:01
 */
@Service
@Slf4j
public class ProductService implements IProductService {

    private final IProductServiceRequest productServiceRequest;

    @Autowired
    public ProductService(IProductServiceRequest productServiceRequest) {
        this.productServiceRequest = productServiceRequest;
    }

    @Override
    public JsonElement saveProduct(JsonElement requestBody) {

        return RetrofitUtils.execute(productServiceRequest.saveProduct(requestBody));

    }

    @Override
    public void deleteProduct(Long productId) {
        RetrofitUtils.execute(productServiceRequest.deleteProduct(productId));
    }

    @Override
    public List<JsonElement> getAllProducts() {
        return RetrofitUtils.execute(productServiceRequest.getAllProducts());
    }

}
