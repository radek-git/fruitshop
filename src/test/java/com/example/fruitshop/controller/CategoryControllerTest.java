package com.example.fruitshop.controller;

import com.example.fruitshop.model.Category;
import com.example.fruitshop.service.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {

    @Mock
    CategoryService categoryService;

    @InjectMocks
    CategoryController categoryController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    public void categoryList() throws Exception {
        Category c1 = new Category();
        Category c2 = new Category();
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(c1);
        categoryList.add(c2);

        when(categoryService.getAllCategories()).thenReturn(categoryList);

        mockMvc.perform(get("/api/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)));
    }

    @Test
    public void byNameTest () throws Exception {
        Category c1 =new Category(1L,"fruits", "/api/categories/fruits");
        when(categoryService.findCategoryByName(anyString())).thenReturn(c1);

        mockMvc.perform(get("/api/categories/fruits"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("fruits")))
                .andExpect(jsonPath("$.url", equalTo("/api/categories/fruits")));
    }
}
