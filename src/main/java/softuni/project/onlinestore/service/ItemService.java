package softuni.project.onlinestore.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.project.onlinestore.db.model.Image;
import softuni.project.onlinestore.db.model.Item;
import softuni.project.onlinestore.db.repository.ImageRepository;
import softuni.project.onlinestore.db.repository.ItemRepository;
import softuni.project.onlinestore.dto.ImageDto;
import softuni.project.onlinestore.dto.ItemDetailsDto;
import softuni.project.onlinestore.dto.ItemDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ImageRepository imageRepository;
    private final ModelMapper modelMapper;

    public ItemService(ItemRepository itemRepository, ImageRepository imageRepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.imageRepository = imageRepository;
        this.modelMapper = modelMapper;
    }

    public List<ItemDto> getAll() {
        return itemRepository.findAll().stream()
                .map(item -> modelMapper.map(item, ItemDto.class))
                .map(this::addMainImages)
                .collect(Collectors.toList());
    }

    public List<ItemDto> getByCategoryAndSubcategory(long categoryId, long subcategoryId) {
        return itemRepository.findByCategoryIdAndSubcategoryId(categoryId, subcategoryId).stream()
                .map(item -> modelMapper.map(item, ItemDto.class))
                .map(this::addMainImages)
                .collect(Collectors.toList());
    }

    public ItemDetailsDto getItemDetails(long itemId) {
        Optional<Item> itemOpt = itemRepository.findById(itemId);
        if (itemOpt.isPresent()) {
            ItemDetailsDto itemDetailsDto = modelMapper.map(itemOpt.get(), ItemDetailsDto.class);
            return addAllImages(itemDetailsDto);
        }
        return new ItemDetailsDto();
    }


    private ItemDto addMainImages(ItemDto itemDto) {
        Optional<Image> imageOpt = imageRepository.findByItemId(itemDto.getId()).stream()
                .filter(Image::isMain)
                .findFirst();
        imageOpt.ifPresent(image -> itemDto.setMainImagePath(image.getPath()));
        return itemDto;
    }

    private ItemDetailsDto addAllImages(ItemDetailsDto itemDetailsDto) {
        itemDetailsDto.setImages(imageRepository.findByItemId(itemDetailsDto.getId()).stream()
                .map(image -> modelMapper.map(image, ImageDto.class))
                .collect(Collectors.toList()));
        return itemDetailsDto;
    }
}
