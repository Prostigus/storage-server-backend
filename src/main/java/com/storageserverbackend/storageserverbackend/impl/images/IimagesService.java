package com.storageserverbackend.storageserverbackend.impl.images;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IimagesService {
    Images save(Images image);

    Page<Images> fetchList(List<Integer> people, List<Integer> categories, Boolean fav, Pageable pageable);

    Images fetchById(Integer id);

    Images update(Images image, Integer id);

    void delete(Integer id);
}
