package net.okur.productservice.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author dogancan.okur
 * 10.12.2022 00:25
 */
@Entity
@Table(name = "category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "title", length = 50, nullable = false)
    private String title;
    @Column(name = "created_date_time", nullable = false)
    @CreatedDate
    private LocalDateTime createdDateTime;
//    @OneToMany(mappedBy = "category")
//    private List<Product> productList;
}
