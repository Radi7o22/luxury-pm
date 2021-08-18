package softuni.project.onlinestore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.project.onlinestore.dto.DeliveryServiceDto;
import softuni.project.onlinestore.service.DeliveryService;

import java.util.List;

@RestController
@RequestMapping("/delivery-services")
public class DeliveryServiceController {

    private final DeliveryService deliveryService;

    public DeliveryServiceController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/all")
    public List<DeliveryServiceDto> getAll() {
        return deliveryService.getAll();
    }
}
