package net.okur.productservice.service.impl;

import net.okur.productservice.dto.output.CategoryOutput;
import net.okur.productservice.dto.output.ServiceOutput;
import net.okur.productservice.model.Category;
import net.okur.productservice.model.Product;
import net.okur.productservice.repository.CategoryRepository;
import net.okur.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author dogancan.okur
 * 10.12.2022 00:33
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryOutput saveCategory(Category category) {
        CategoryOutput categoryOutput = new CategoryOutput();
        Optional<Category> dbCategory = categoryRepository.findById(category.getId());
        if (dbCategory.isPresent()) {
            categoryOutput.setStatus(ServiceOutput.Status.ERROR);
            categoryOutput.setMessage("Category found, not saved");
            return categoryOutput;
        }
        Category savedCategory = categoryRepository.save(category);
        categoryOutput.setMessage("saved");
        categoryOutput.setStatus(ServiceOutput.Status.SUCCESS);
        categoryOutput.setId(savedCategory.getId());
        categoryOutput.setTitle(savedCategory.getTitle());
//        categoryOutput.setProductList(savedCategory.getProductList());

        return categoryOutput;
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllProductsByCategory(Category category) {
        return null;
    }

    @Override
    public Category findCategoryByProductId(Long id) {
        return null;
    }
}
