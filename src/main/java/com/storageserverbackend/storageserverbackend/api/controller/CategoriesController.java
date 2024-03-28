package com.storageserverbackend.storageserverbackend.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.storageserverbackend.storageserverbackend.impl.categories.Categories;
import com.storageserverbackend.storageserverbackend.impl.categories.ICategoriesService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class CategoriesController {
    @Autowired private ICategoriesService categoriesService;

    @PostMapping("/categories")
    public Categories saveCategory(@RequestBody Categories category) {        
        return categoriesService.save(category);
    }

    @GetMapping("/categories")
    public List<Categories> getCategories() {
        return categoriesService.fetchList();
    }

    @GetMapping("/categories/{id}")
    public Categories getCategory(@PathVariable String id) {
        return categoriesService.fetchById(Integer.parseInt(id));
    }

    @PutMapping("categories/{id}")
    public Categories updateCategory(@PathVariable String id, @RequestBody Categories category) {
        return categoriesService.update(category, Integer.parseInt(id));
    }
    
    
}
