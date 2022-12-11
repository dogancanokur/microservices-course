package net.okur.rabbitmq.controller;

import net.okur.rabbitmq.model.Notification;
import net.okur.rabbitmq.model.Product;
import net.okur.rabbitmq.producer.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dogancan.okur
 * 11.12.2022 18:53
 */
@RestController
public class NotificationRestController {
    @Autowired
    private NotificationProducer notificationProducer;

    @PostMapping("/producer")
    public ResponseEntity<?> procuder(@RequestBody Notification notification) {
        notificationProducer.sendToQueue(notification);
        return new ResponseEntity<>("Add to queue", HttpStatus.OK);
    }

    @PostMapping("/producer-2")
    public ResponseEntity<?> procuder2(@RequestBody Product product) {
        notificationProducer.sendToQueueNew(product);
        return new ResponseEntity<>("Add to queue product", HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
//        notificationProducer.sendToQueue(notification);
        System.out.println("test");
        return new ResponseEntity<>("Add to queue", HttpStatus.OK);
    }
}
