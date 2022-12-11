package net.okur.productservice.events.api;

import net.okur.productservice.events.service.ProductEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dogancan.okur
 * 11.12.2022 04:38
 */
@RestController
public class ProductEventApi {

    @Autowired
    private ProductEventService productEventService;

    @PostMapping("/api/test")
    public void testMethod(@RequestBody ProductEventRequest productEventRequest) {
        productEventService.publishProductEvent(productEventRequest);
        System.out.println("istek isleme alindi. " + productEventRequest);
    }
}
