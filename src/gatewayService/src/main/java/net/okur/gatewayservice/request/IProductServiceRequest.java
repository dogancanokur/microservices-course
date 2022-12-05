package net.okur.gatewayservice.request;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * @author dogancan.okur
 * 5.12.2022 01:01
 */
public interface IProductServiceRequest {

    @POST("/api/v1/product")
    public Call<JsonElement> saveProduct(@Body JsonElement requestBody);

    @DELETE("/api/v1/product/{productId}")
    public Call<Void> deleteProduct(@Path("productId") Long productId);

    @GET("/api/v1/product")
    Call<List<JsonElement>> getAllProducts();
}
