package net.okur.productservice.dto.output;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dogancan.okur
 * 10.12.2022 00:36
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductOutput extends ServiceOutput {
    private Long id;
    private String name;
    private String productCode;
    private Double price;
    private int quantity;
    private String createTime;
    private Long createdUserId;
    private String updateTime;
    private Long updatedAt;
    private CategoryOutput categoryOutput;
}
