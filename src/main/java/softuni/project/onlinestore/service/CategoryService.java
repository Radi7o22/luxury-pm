package softuni.project.onlinestore.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.project.onlinestore.db.repository.CategoryRepository;
import softuni.project.onlinestore.dto.CategoryDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public List<CategoryDto> getCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

}
