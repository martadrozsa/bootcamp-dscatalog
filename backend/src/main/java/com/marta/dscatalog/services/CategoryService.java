package com.marta.dscatalog.services;


import com.marta.dscatalog.entities.Category;
import com.marta.dscatalog.resources.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    Category insert(Category category);
}
