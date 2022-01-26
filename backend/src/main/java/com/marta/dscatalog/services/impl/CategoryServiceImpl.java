package com.marta.dscatalog.services.impl;

import com.marta.dscatalog.entities.Category;
import com.marta.dscatalog.repositories.CategoryRepository;
import com.marta.dscatalog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl  implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
