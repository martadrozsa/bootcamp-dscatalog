package com.marta.dscatalog.services.impl;

import com.marta.dscatalog.entities.Category;
import com.marta.dscatalog.repositories.CategoryRepository;
import com.marta.dscatalog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl  implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
