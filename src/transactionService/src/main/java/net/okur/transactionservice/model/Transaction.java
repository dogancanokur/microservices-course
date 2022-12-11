package net.okur.transactionservice.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author dogancan.okur
 * @date 3.12.2022
 * @time 21:14
 */
@Entity
@Table(name = "transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "transaction_date_time")
    private LocalDateTime transactionDateTime;
    // todo fix below
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "product_code", nullable = false, unique = true, length = 100)
    private String productCode;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

}
