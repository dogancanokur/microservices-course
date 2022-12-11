package net.okur.rabbitmq.connection;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author dogancan.okur
 * 11.12.2022 20:24
 */
public interface TransactionConnectionService {
    @POST("/api/v1/transaction/")
    Call<Void> saveTransaction(@Body JsonElement requestBody);
}
