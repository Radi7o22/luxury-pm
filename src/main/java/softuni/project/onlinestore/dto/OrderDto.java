package softuni.project.onlinestore.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDto {

    private LocalDateTime desiredDeliveryDate;
    private long deliveryServiceId;
    private long userId;
    private String firstName;
    private String lastName;
    private String address;
    private String additionalInfo;
    private List<ItemInOrderDto> items;

}
