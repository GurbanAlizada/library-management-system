package com.example.librarysystem.service;


import com.example.librarysystem.dto.request.AddCategoryRequest;
import com.example.librarysystem.dto.response.CategoryDto;
import com.example.librarysystem.exception.CategoryNotFoundException;
import com.example.librarysystem.model.Category;
import com.example.librarysystem.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service public class CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Transactional
    public void addCategory(AddCategoryRequest request) {
        Category category = new Category(request.categoryName());
        categoryRepository.save(category);
    }


    public List<CategoryDto> getAll() {
        List<Category> categories = categoryRepository.findAll();
        final var result =  categories.stream()
                .map(n->CategoryDto.convert(n)).collect(Collectors.toList());
        return result;
    }

    public CategoryDto getById(Long id) {
        Category category = getCategoryById(id);
        final var result = CategoryDto.convert(category);
        return result;
    }


    protected Category getCategoryById(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("category not found : " + id));
        return category;
    }


}
