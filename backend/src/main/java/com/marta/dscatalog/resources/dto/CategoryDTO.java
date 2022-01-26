package com.marta.dscatalog.resources.dto;

import com.marta.dscatalog.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO(Category categoryEntity) {
        this.id = categoryEntity.getId();
        this.name = categoryEntity.getName();
    }

}
