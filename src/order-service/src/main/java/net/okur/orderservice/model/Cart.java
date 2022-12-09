package net.okur.orderservice.model;

import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * @author dogancan.okur
 * 5.12.2022 04:10
 */
@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "create_time")
    @CreationTimestamp
    private LocalDateTime createTime;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
