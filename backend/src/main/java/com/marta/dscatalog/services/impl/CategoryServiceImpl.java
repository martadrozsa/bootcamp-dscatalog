package com.marta.dscatalog.services.impl;

import com.marta.dscatalog.entities.Category;
import com.marta.dscatalog.repositories.CategoryRepository;
import com.marta.dscatalog.services.CategoryService;
import com.marta.dscatalog.services.exceptions.DataBaseException;
import com.marta.dscatalog.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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

        Category categoryEntity = categoryOptional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return categoryEntity;
    }

    @Transactional
    @Override
    public void insert(Category category) {
        categoryRepository.save(category);
    }

    @Transactional
    @Override
    public Category update(Long id, Category category) {
        try {
            Category savedCategory = categoryRepository.getById(id);
            savedCategory.setName(category.getName());
            return categoryRepository.save(savedCategory);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw  new DataBaseException("Integrity violation");
        }
    }

    @Override
    public void deleteById(Long id) {
        try{
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found");
        }
    }
}
