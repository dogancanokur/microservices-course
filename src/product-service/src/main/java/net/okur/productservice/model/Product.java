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

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "createTime", nullable = false)
    private LocalDateTime createTime;
}
