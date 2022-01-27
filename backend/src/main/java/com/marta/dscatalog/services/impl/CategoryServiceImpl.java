package com.marta.dscatalog.services.impl;

import com.marta.dscatalog.entities.Category;
import com.marta.dscatalog.repositories.CategoryRepository;
import com.marta.dscatalog.services.CategoryService;
import com.marta.dscatalog.services.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl  implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Category findById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        Category categoryEntity = categoryOptional.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return categoryEntity;
    }

    @Transactional
    @Override
    public Category insert(Category category) {
        return categoryRepository.save(category);
    }
}
