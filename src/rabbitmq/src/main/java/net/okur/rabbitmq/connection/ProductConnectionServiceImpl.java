package net.okur.rabbitmq.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import net.okur.rabbitmq.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author dogancan.okur
 * 11.12.2022 20:29
 */
@Service
public class ProductConnectionServiceImpl {
    private final TransactionConnectionService transactionConnectionService;

    @Autowired
    public ProductConnectionServiceImpl(TransactionConnectionService transactionConnectionService) {
        this.transactionConnectionService = transactionConnectionService;
    }

    public void sendTransaction(Product product) throws IOException {

        Gson gson = new GsonBuilder().create();
        JsonElement element = gson.toJsonTree(product, Product.class);

        transactionConnectionService.saveTransaction(element).execute();

    }
}
