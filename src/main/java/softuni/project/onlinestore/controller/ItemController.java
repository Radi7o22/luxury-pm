package softuni.project.onlinestore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.project.onlinestore.dto.ItemDetailsDto;
import softuni.project.onlinestore.dto.ItemDto;
import softuni.project.onlinestore.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    public List<ItemDto> getAll() {
        return itemService.getAll();
    }

    @GetMapping("/category/{categoryId}/subcategory/{subcategoryId}")
    public List<ItemDto> findByCategoryAndSubcategory(
            @PathVariable(name = "categoryId") long categoryId,
            @PathVariable(name = "subcategoryId") long subcategoryId) {
        return itemService.getByCategoryAndSubcategory(categoryId, subcategoryId);
    }

    @GetMapping("/{itemId}")
    public ItemDetailsDto getItemDetails(@PathVariable(name = "itemId") long itemId) {
        return itemService.getItemDetails(itemId);
    }
}
