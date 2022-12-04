package net.okur.gatewayservice.request;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * @author dogancan.okur
 * 5.12.2022 02:16
 */
public interface ITransactionServiceRequest {

    @POST("/api/transaction")
    Call<JsonElement> saveTransaction(@Body JsonElement requestBody);

    @DELETE("/api/transaction/{transactionId}")
    Call<Void> deleteTransaction(@Path("transactionId") Long transactionId);

    @GET("/api/transaction/{userId}")
    Call<List<JsonElement>> getAllTransactionOfAuthorizedUser(@Path("userId") Long userId);
}
