package com.marta.dscatalog.resources.mapper;

import com.marta.dscatalog.entities.Category;
import com.marta.dscatalog.resources.dto.CategoryDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryDTOMapper {

    Category mapCategoryDTOToCategory(CategoryDTO categoryDTO);

    //o controller recebeu category do service e mapeou para um DTO antes de enviar a resposta
    CategoryDTO mapCategoryToCategoryDTO(Category category);

    List<CategoryDTO> mapCategoriesToCategoriesDTO(List<Category> categoryList);
}
