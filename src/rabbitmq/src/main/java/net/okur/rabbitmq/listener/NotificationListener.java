package net.okur.rabbitmq.listener;

import net.okur.rabbitmq.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author dogancan.okur
 * 11.12.2022 02:23
 */
@Service
public class NotificationListener {
    // process
    // todo get from application.properties
    @RabbitListener(queues = "microservice-queue")
    public void handleMessage(Notification notification) {
        System.out.println("Message received.");
        System.out.println(notification.toString());
    }
}
