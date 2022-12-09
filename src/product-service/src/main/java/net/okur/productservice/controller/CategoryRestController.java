package net.okur.productservice.controller;

import io.swagger.annotations.ApiOperation;
import net.okur.productservice.dto.output.CategoryOutput;
import net.okur.productservice.dto.output.ServiceOutput;
import net.okur.productservice.model.Category;
import net.okur.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dogancan.okur
 * 8.10.2022 04:24
 */

@RestController
@RequestMapping("api/v1/category") // pre-path
@ApiOperation(value = "Category Rest Controller - FAE")
public class CategoryRestController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping // =>  api/v1/category
    @ApiOperation(value = "Save Category", httpMethod = "POST")
    public ResponseEntity<?> saveProduct(@RequestBody Category category) {
        CategoryOutput categoryOutput = categoryService.saveCategory(category);

        if (ServiceOutput.Status.ERROR.equals(categoryOutput.getStatus())) {
            return new ResponseEntity<>(categoryOutput, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(categoryOutput, HttpStatus.CREATED);
    }
}
