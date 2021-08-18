package softuni.project.onlinestore.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.project.onlinestore.db.repository.DeliveryServiceRepository;
import softuni.project.onlinestore.dto.DeliveryServiceDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryService {

    private final DeliveryServiceRepository deliveryServiceRepository;
    private final ModelMapper modelMapper;

    public DeliveryService(DeliveryServiceRepository deliveryServiceRepository, ModelMapper modelMapper) {
        this.deliveryServiceRepository = deliveryServiceRepository;
        this.modelMapper = modelMapper;
    }

    public List<DeliveryServiceDto> getAll() {
        return deliveryServiceRepository.findAll().stream()
                .map(deliveryService -> modelMapper.map(deliveryService, DeliveryServiceDto.class))
                .collect(Collectors.toList());
    }
}
