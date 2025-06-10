package com.example.expense_tracker_app.service;

import com.example.expense_tracker_app.dto.CategoryDto;
import com.example.expense_tracker_app.entity.Category;
import com.example.expense_tracker_app.exceptionHandler.ResourceNotFoundException;
import com.example.expense_tracker_app.mapper.CategoryMapper;
import com.example.expense_tracker_app.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.expense_tracker_app.mapper.CategoryMapper.*;
@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository repo;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        return CategoryMapper.mapToCategoryDto(repo.save(CategoryMapper.mapToCategory(categoryDto)));
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return CategoryMapper.mapToCategoryDto(repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Category is found by this id ="+id)));
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> nam=repo.findAll();
        return nam.stream().map(CategoryMapper::mapToCategoryDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
         Category nam=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("No Category is found by this id ="+id));
         nam.setName(categoryDto.name());
        return CategoryMapper.mapToCategoryDto(repo.save(nam)) ;
    }

    @Override
    public void deletecategory(Long id) {
        Category nam=repo.findById(id)
                     .orElseThrow(()-> new ResourceNotFoundException("we can't find this id related data : "+id));
        repo.delete(nam);
    }
}
