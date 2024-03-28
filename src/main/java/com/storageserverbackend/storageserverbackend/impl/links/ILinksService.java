package com.storageserverbackend.storageserverbackend.impl.links;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ILinksService {
    Links save(Links link);

    Page<Links> fetchList(List<Integer> people, List<Integer> categories, Boolean fav, Pageable pageable);

    Links fetchById(Integer id);

    Links update(Links link, Integer id);

    void delete(Integer id);
}
