package net.okur.productservice.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author dogancan.okur
 * 8.10.2022 04:01
 */

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "product_code", nullable = false, unique = true, length = 100)
    private String productCode;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @Column(name = "created_user_id", nullable = false)
    private Long createdUserId;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Column(name = "updated_user_id")
    private Long updatedAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
