package com.storageserverbackend.storageserverbackend.impl.links;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

import static com.storageserverbackend.storageserverbackend.impl.links.LinksSpecification.*;

@Service
public class LinksService implements ILinksService {

    @Autowired
    private LinksRepository linksRepository;

    @Override
    public Links save(Links link) {
        return linksRepository.save(link);
    }

    @Override
    public Page<Links> fetchList(List<Integer> people, List<Integer> categories, Boolean fav, Pageable pageable) {
        Specification<Links> filters = Specification
                .where(CollectionUtils.isEmpty(people) ? null : hasPeople(people))
                .and(CollectionUtils.isEmpty(categories) ? null : hasCategories(categories))
                .and(fav == null ? null : hasFavourite());

        return linksRepository.findAll(filters, pageable);
    }

    @Override
    public Links fetchById(Integer id) {
        return linksRepository.findById(id).get();
    }

    @Override
    public Links update(Links link, Integer id) {
        Links linksDB = linksRepository.findById(id).get();

        if (Objects.nonNull(link.getDescription())) {
            linksDB.setDescription(link.getDescription());
        }

        if (Objects.nonNull(link.getCategories())) {
            linksDB.setCategories(link.getCategories());
        }

        if (Objects.nonNull(link.getPeople())) {
            linksDB.setPeople(link.getPeople());
        }

        if (linksDB.getFav() != link.getFav()) {
            linksDB.setFav(link.getFav());
        }

        return linksRepository.save(linksDB);
    }

    @Override
    public void delete(Integer id) {
        linksRepository.deleteById(id);
    }

}
