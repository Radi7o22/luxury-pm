package softuni.project.onlinestore.dto;

import lombok.Data;

@Data
public class ItemDto {

    private long id;
    private String name;
    private float price;
    private String categoryName;
    private String subcategoryName;
    private String mainImagePath;

}
