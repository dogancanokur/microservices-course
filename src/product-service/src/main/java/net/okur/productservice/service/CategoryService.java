package net.okur.productservice.service;

import net.okur.productservice.dto.output.CategoryOutput;
import net.okur.productservice.model.Category;
import net.okur.productservice.model.Product;

import java.util.List;

/**
 * @author dogancan.okur
 * 10.12.2022 00:31
 */
public interface CategoryService {

    CategoryOutput saveCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategoryById(Long id);

    List<Product> findAllProductsByCategory(Category category);

    Category findCategoryByProductId(Long id);
}
