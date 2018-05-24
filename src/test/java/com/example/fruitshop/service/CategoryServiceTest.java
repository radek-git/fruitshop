package com.example.fruitshop.service;

import com.example.fruitshop.model.Category;
import com.example.fruitshop.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

    @Mock
    CategoryRepository categoryRepository;

    CategoryService categoryService;

    @Before
    public void setUp() throws Exception {
        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    public void getAllCategoriesTest() {
        //given
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L,"fruits", "/api/categories/fruits"));
        categories.add(new Category(2L,"fruits", "/api/categories/fruits"));
        when(categoryRepository.findAll()).thenReturn(categories);
        //when
        List<Category> allCategories = categoryService.getAllCategories();
        //then
        assertThat(allCategories.size(), is(2));
    }

    @Test
    public void getCategoryByNameTest (){
        Category c1 =new Category(1L,"fruits", "/api/categories/fruits");
        when(categoryRepository.findByName(anyString())).thenReturn(c1);
        Category fruits = categoryService.findCategoryByName("fruits");
        assertEquals("fruits",fruits.getName());
        assertEquals("/api/categories/fruits", fruits.getUrl());

    }
}