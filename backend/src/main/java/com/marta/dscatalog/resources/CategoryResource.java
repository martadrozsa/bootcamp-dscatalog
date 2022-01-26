package com.marta.dscatalog.resources;

import com.marta.dscatalog.entities.Category;
import com.marta.dscatalog.resources.dto.CategoryDTO;
import com.marta.dscatalog.resources.mapper.CategoryDTOMapper;
import com.marta.dscatalog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    private final CategoryService categoryService;

    private  final CategoryDTOMapper categoryDTOMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<Category> categoryList = categoryService.findAll();
        List<CategoryDTO> categoryDTOList = categoryDTOMapper.mapCategoriesToCategoriesDTO(categoryList);
        return ResponseEntity.ok().body(categoryDTOList);
    }
}
