package com.storageserverbackend.storageserverbackend.impl.categories;

import java.util.List;


public interface ICategoriesService {
    Categories save(Categories category);

    List<Categories> fetchList();

    Categories fetchById(Integer id);

    Categories update(Categories category, Integer id);

    void delete(Integer id);
}
