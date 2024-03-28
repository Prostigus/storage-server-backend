package com.storageserverbackend.storageserverbackend.impl.images;

import com.storageserverbackend.storageserverbackend.impl.categories.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

import static com.storageserverbackend.storageserverbackend.impl.images.ImagesSpecification.*;

@Service
public class ImagesService implements IimagesService {

    @Autowired
    private ImagesRepository imagesRepository;

    @Autowired
    private ICategoriesService iCategoriesService;

    @Override
    public Images save(Images image) {
        return imagesRepository.save(image);
    }

    @Override
    public Page<Images> fetchList(List<Integer> people, List<Integer> categories, Boolean fav, Pageable pageable) {
        Specification<Images> filters = Specification
                .where(CollectionUtils.isEmpty(people) ? null : hasPeople(people))
                .and(CollectionUtils.isEmpty(categories) ? null : hasCategories(categories))
                .and(fav == null ? null : hasFavourite());
        return imagesRepository.findAll(filters, pageable);
    }

    @Override
    public Images fetchById(Integer id) {
        return imagesRepository.findById(id).get();
    }

    @Override
    public Images update(Images image, Integer id) {
        Images imageDB = fetchById(id);

        if (Objects.nonNull(image.getDescription())) {
            imageDB.setDescription(image.getDescription());
        }

        if (Objects.nonNull(image.getCategories())) {
            imageDB.setCategories(image.getCategories());
        }

        if (Objects.nonNull(image.getPeople())) {
            imageDB.setPeople(image.getPeople());
        }

        if (imageDB.getFav() != image.getFav()) {
            imageDB.setFav(image.getFav());
        }

        return imagesRepository.save(imageDB);
    }

    @Override
    public void delete(Integer id) {
        imagesRepository.deleteById(id);
    }

}
