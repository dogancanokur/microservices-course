package net.okur.rabbitmq.model;

import java.io.Serializable;

/**
 * @author dogancan.okur
 * 11.12.2022 02:20
 */
public class Product implements Serializable {
    private String name;
    private String productCode;
    private String price;
    private String quantity;
    private String createdUserId;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", productCode='" + productCode + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                ", createdUserId='" + createdUserId + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }


}
