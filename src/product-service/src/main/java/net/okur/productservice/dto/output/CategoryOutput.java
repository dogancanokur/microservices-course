package net.okur.productservice.dto.output;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.okur.productservice.model.Product;

import java.util.List;

/**
 * @author dogancan.okur
 * 10.12.2022 00:36
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CategoryOutput extends ServiceOutput {
    private Long id;
    private String title;
    private List<Product> productList;
}
