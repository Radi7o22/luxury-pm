package softuni.project.onlinestore.dto;

import lombok.Data;

import java.util.List;

@Data
public class ItemDetailsDto {

    private long id;
    private String name;
    private float price;
    private String color;
    private float width;
    private float length;
    private float thickness;
    private float height;
    private String description;
    private String categoryName;
    private String subcategoryName;
    private List<ImageDto> images;

}

