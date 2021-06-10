package com.rapisolver.attention.services.impl;

import com.rapisolver.attention.client.UserClient;
import com.rapisolver.attention.dtos.CategoryDTO;
import com.rapisolver.attention.dtos.CreateCategoryDTO;
import com.rapisolver.attention.entities.Category;
import com.rapisolver.attention.exceptions.InternalServerErrorException;
import com.rapisolver.attention.exceptions.NotFoundException;
import com.rapisolver.attention.repository.CategoryRepository;
import com.rapisolver.attention.services.CategoryService;
import com.rapisolver.attention.util.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    @Override
    public CategoryDTO create(CreateCategoryDTO t) throws RuntimeException {
        try {
            Category category = new Category();
            category.setName(t.getName());
            category.setDescription(t.getDescription());
            category.setCreatedAt(new Date());
            category.setStatus(String.valueOf(Status.CREATED));
            category = categoryRepository.save(category);
            return mapper.map(category, CategoryDTO.class);
        } catch (Exception e) {
            throw new InternalServerErrorException("CREATE_CATEGORY_ERROR");
        }
    }

    @Override
    public List<CategoryDTO> getAll() throws RuntimeException {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(c -> mapper.map(c, CategoryDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getById(Long aLong) throws RuntimeException {
        Category categoryDB = categoryRepository.findById(aLong).orElseThrow(() -> new NotFoundException("Categoria con id="+aLong+" no encontrada"));
        return mapper.map(categoryDB, CategoryDTO.class);
    }

    @Transactional
    @Override
    public CategoryDTO update(Long aLong, CreateCategoryDTO t) throws RuntimeException {
        Category categoryDB = categoryRepository.findById(aLong).orElseThrow(() -> new NotFoundException("Categoria con id="+aLong+" no encontrada"));
        try {
            categoryDB.setName(t.getName());
            categoryDB.setDescription(t.getDescription());
            categoryDB.setStatus(String.valueOf(Status.UPDATED));
            categoryDB = categoryRepository.save(categoryDB);
            return mapper.map(categoryDB, CategoryDTO.class);
        } catch (Exception e) {
            throw new InternalServerErrorException("UPDATE_CATEGORY_ERROR");
        }
    }

    @Transactional
    @Override
    public CategoryDTO deleteById(Long aLong) throws RuntimeException {
        Category categoryDB = categoryRepository.findById(aLong).orElseThrow(() -> new NotFoundException("Categoria con id="+aLong+" no encontrada"));
        try {
            categoryDB.setStatus(String.valueOf(Status.DELETED));
            categoryDB = categoryRepository.save(categoryDB);
            return mapper.map(categoryDB, CategoryDTO.class);
        } catch (Exception e) {
            throw new InternalServerErrorException("DELETE_CATEGORY_ERROR");
        }
    }
}
