package com.marta.dscatalog.resources;

import com.marta.dscatalog.entities.Category;
import com.marta.dscatalog.resources.dto.CategoryDTO;
import com.marta.dscatalog.resources.mapper.CategoryDTOMapper;
import com.marta.dscatalog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        CategoryDTO categoryDTO = categoryDTOMapper.mapCategoryToCategoryDTO(category);
        return ResponseEntity.ok().body(categoryDTO);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO categoryDTO) {
        Category category = categoryDTOMapper.mapCategoryDTOToCategory(categoryDTO);
        categoryService.insert(category);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        Category category = categoryDTOMapper.mapCategoryDTOToCategory(categoryDTO);
        Category categoryUpdated = categoryService.update(id, category);
        CategoryDTO categoryDTOUpdated = categoryDTOMapper.mapCategoryToCategoryDTO(categoryUpdated);

        return ResponseEntity.ok().body(categoryDTOUpdated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
