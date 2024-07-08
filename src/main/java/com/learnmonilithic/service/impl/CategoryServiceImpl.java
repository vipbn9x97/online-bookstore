package com.learnmonilithic.service.impl;

import com.learnmonilithic.entity.Category;
import com.learnmonilithic.exception.DuplicateException;
import com.learnmonilithic.exception.ResourceNotFoundException;
import com.learnmonilithic.exception.SQLException;
import com.learnmonilithic.payload.request.CategoryRequest;
import com.learnmonilithic.repository.CategoryRepository;
import com.learnmonilithic.service.CategoryService;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories(CategoryRequest request) {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        if (categoryRepository.findById(id).isPresent()) { 
            return categoryRepository.findById(id).get();
        } else throw new ResourceNotFoundException("Không tìm thấy");
    }

    @Override
    public Category addCategory(Category category) {
        Objects.requireNonNull(category, "Category information must not be blank");
        if (StringUtils.isBlank(category.getCategoryName()))
            throw new IllegalArgumentException("Tên danh mục không được để trống");
        if (categoryRepository.existsByCategoryName(category.getCategoryName())) {
            throw new DuplicateException("Category name is already exist");
        }
        try {
            return categoryRepository.save(category);
        } catch (DataIntegrityViolationException e) {
            throw new SQLException("Lỗi lưu danh mục vào cơ sở dữ liệu", e);
        }
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        if (categoryRepository.findById(id).isPresent()) {
            Category currentCategory = categoryRepository.findById(id).get();
            currentCategory.setCategoryName(category.getCategoryName());
            return categoryRepository.save(currentCategory);
        } else throw new ResourceNotFoundException("Không tìm thấy");
    }

    @Override
    public void deleteCategory(Long id) {
        if (categoryRepository.findById(id).isPresent()) {
            categoryRepository.deleteById(id);
        } else throw new ResourceNotFoundException("Không tìm thấy");
    }
}
