package softuni.project.onlinestore.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.project.onlinestore.dto.OrderDto;
import softuni.project.onlinestore.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //Example JSON body
//    {
//        "desiredDeliveryDate": "2021-07-26T12:08:58.479Z",
//            "deliveryServiceId": 1,
//            "userId": 1,
//            "address": "Ofisa na ekont na ulica Radost da mi e po-blizko",
//            "additionalInfo": "Nqmam pari za plashtane na poruchkata. Tova predstavlqva li problem za vas?",
//            "items": [
//        {
//            "itemId": 2,
//                "quantity": 10
//        },
//        {
//            "itemId": 3,
//                "quantity": 20
//        }
//   ]
//    }
    @PostMapping("/make")
    public OrderDto makeOrder(@RequestBody OrderDto orderDto) {
        return orderService.makeOrder(orderDto);
    }

}
