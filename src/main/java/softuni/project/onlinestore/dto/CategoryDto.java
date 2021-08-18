package softuni.project.onlinestore.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CategoryDto {

    private long id;
    private String name;
    private String description;
    private Set<SubcategoryDto> subcategories;

}
