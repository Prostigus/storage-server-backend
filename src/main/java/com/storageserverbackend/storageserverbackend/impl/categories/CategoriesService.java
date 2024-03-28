package com.storageserverbackend.storageserverbackend.impl.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CategoriesService implements ICategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public Categories save(Categories category) {
        return categoriesRepository.save(category);
    }

    @Override
    public List<Categories> fetchList() {
        return (List<Categories>) categoriesRepository.findAll();
    }

    @Override
    public Categories fetchById(Integer id) {
        return categoriesRepository.findById(id).get();
    }

    @Override
    public Categories update(Categories category, Integer id) {
        Categories categoriesDB = categoriesRepository.findById(id).get();

        if (Objects.nonNull(category.getDescription())) {
            categoriesDB.setDescription(category.getDescription());
        }

        return categoriesRepository.save(categoriesDB);
    }

    @Override
    public void delete(Integer id) {
        categoriesRepository.deleteById(id);
    }

}
