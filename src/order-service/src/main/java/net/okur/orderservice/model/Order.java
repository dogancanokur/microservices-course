package net.okur.orderservice.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author dogancan.okur
 * 5.12.2022 04:22
 */
@Entity
@Table(name = "order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;


    private Long userId;

    @OneToMany(mappedBy = "order")
    private Set<Cart> cart;
}
