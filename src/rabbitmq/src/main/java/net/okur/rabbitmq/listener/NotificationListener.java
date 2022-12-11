package net.okur.rabbitmq.listener;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import net.okur.rabbitmq.connection.TransactionConnectionService;
import net.okur.rabbitmq.model.Product;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author dogancan.okur
 * 11.12.2022 02:23
 */
@Service
public class NotificationListener {
    // process
    // todo get from application.properties
//    @RabbitListener(queues = "microservice-queue")
//    public void handleMessage(Notification notification) {
//        System.out.println("Message received.");
//        System.out.println(notification.toString());
//    }
    @Autowired
    private TransactionConnectionService transactionConnectionService;

    @RabbitListener(queues = "microservice-queue")
    public void handleMessage(Product product) {
        System.out.println("Message received.");

        Gson gson = new GsonBuilder().create();
        JsonElement element = gson.toJsonTree(product, Product.class);

        try {
            transactionConnectionService.saveTransaction(element).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
