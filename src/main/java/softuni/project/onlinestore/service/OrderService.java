package softuni.project.onlinestore.service;

import org.springframework.stereotype.Service;
import softuni.project.onlinestore.db.model.ItemInOrder;
import softuni.project.onlinestore.db.model.Order;
import softuni.project.onlinestore.db.model.user.User;
import softuni.project.onlinestore.db.repository.*;
import softuni.project.onlinestore.dto.OrderDto;

import java.util.Optional;

@Service
public class OrderService {

    private final ItemRepository itemRepository;
    private final ItemInOrderRepository itemInOrderRepository;
    private final OrderRepository orderRepository;
    private final DeliveryServiceRepository deliveryServiceRepository;
    private final UserRepository userRepository;

    public OrderService(ItemRepository itemRepository, ItemInOrderRepository itemInOrderRepository,
                        OrderRepository orderRepository, DeliveryServiceRepository deliveryServiceRepository,
                        UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.itemInOrderRepository = itemInOrderRepository;
        this.orderRepository = orderRepository;
        this.deliveryServiceRepository = deliveryServiceRepository;
        this.userRepository = userRepository;
    }

    public OrderDto makeOrder(OrderDto orderDto) {
        Order order = new Order();
        Optional<User> user = userRepository.findById(orderDto.getUserId());
        order.setDeliveryService(deliveryServiceRepository.findById(orderDto.getDeliveryServiceId()).orElse(null));
        if (user.isPresent()) {
            order.setUser(user.get());
        } else {
            order.setFirstName(orderDto.getFirstName());
            order.setLastName(orderDto.getLastName());
        }
        order.setDesiredDeliveryDate(orderDto.getDesiredDeliveryDate());
        order.setAddress(orderDto.getAddress());
        order.setAdditionalInfo(orderDto.getAdditionalInfo());
        Order persistedOrder = orderRepository.save(order);
        orderDto.getItems().forEach(itemInOrderDto -> {
            ItemInOrder itemInOrder = new ItemInOrder();
            itemInOrder.setItem(itemRepository.findById(itemInOrderDto.getItemId()).orElse(null));
            itemInOrder.setQuantity(itemInOrderDto.getQuantity());
            itemInOrder.setOrder(persistedOrder);
            itemInOrderRepository.save(itemInOrder);
        });
        return orderDto;
    }
}
