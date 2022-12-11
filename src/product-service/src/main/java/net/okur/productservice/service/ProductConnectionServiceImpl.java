package net.okur.productservice.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import lombok.extern.slf4j.Slf4j;
import net.okur.productservice.model.Product;
import net.okur.productservice.service.connection.RabbitMQConnectionService;
import net.okur.productservice.service.connection.TransactionConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author dogancan.okur
 * 11.12.2022 20:29
 */
@Service
@Slf4j
public class ProductConnectionServiceImpl {
    private final RabbitMQConnectionService rabbitMQConnectionService;
    private final TransactionConnectionService transactionConnectionService;

    @Autowired
    public ProductConnectionServiceImpl(RabbitMQConnectionService rabbitMQConnectionService,
                                        TransactionConnectionService transactionConnectionService) {
        this.rabbitMQConnectionService = rabbitMQConnectionService;
        this.transactionConnectionService = transactionConnectionService;
    }

    public void sendTransaction(Product product) {

        Gson gson = new GsonBuilder().create();
        JsonElement element = gson.toJsonTree(product, Product.class);

        try {
            transactionConnectionService.saveTransaction(element).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        return RetrofitUtils.execute(transactionConnectionService.saveTransaction(element));

    }

    public void sendToQueue(Product product) {

        Gson gson = new GsonBuilder().create();
        JsonElement element = gson.toJsonTree(product, Product.class);

        try {
            rabbitMQConnectionService.sendToQueue(element).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
