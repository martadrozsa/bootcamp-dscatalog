package com.marta.dscatalog.services;


import com.marta.dscatalog.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    void insert(Category category);

    Category update(Long id, Category category);
}
