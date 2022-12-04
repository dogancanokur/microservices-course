package net.okur.gatewayservice.utils;

import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * @author dogancan.okur
 * 5.12.2022 01:39
 */
@Slf4j
public class RetrofitUtils {

    public static <T> T execute(Call<T> request) { // senkron

        try {

            Response<T> response = request.execute();
            if (!response.isSuccessful()) {
                log.error("Request completed unsuccessfully with status code:{} and reason:{}",
                        response.code(), response.errorBody().string());
            }
            return response.body();
        } catch (IOException exception) {
            throw new RuntimeException(exception.getCause());
        }

    }
}
