package net.okur.rabbitmq.producer;

import net.okur.rabbitmq.model.Notification;
import net.okur.rabbitmq.model.Product;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author dogancan.okur
 * 11.12.2022 02:24
 */
@Service
public class NotificationProducer {
    // send data
    @Value("${rabbit.routing.name}")
    private String routingName;
    @Value("${rabbit.exchange.name}")
    private String exchangeName;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
//        Notification notification = new Notification();
//        notification.setNotificationId(UUID.randomUUID().toString());
//        notification.setCreatedAt(new Date());
//        notification.setMessage("Faecon notification");
//        notification.setSeen(Boolean.FALSE);
//
//        sendToQueue(notification);
    }

    public void sendToQueue(Notification notification) {
        System.out.println("Notification Sent ID:" + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName, routingName, notification);
    }

    public void sendToQueueNew(Product product) {
        System.out.println("Product Sent ID:" + product.getName());
        rabbitTemplate.convertAndSend(exchangeName, routingName, product);
    }
}
