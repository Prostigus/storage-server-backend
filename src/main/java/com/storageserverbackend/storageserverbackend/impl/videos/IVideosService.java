package com.storageserverbackend.storageserverbackend.impl.videos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IVideosService {
    Videos save(Videos video);

    Page<Videos> fetchList(List<Integer> people, List<Integer> categories, Boolean fav, Pageable pageable);

    Videos fetchById(Integer id);

    Videos update(Videos video, Integer id);

    void delete(Integer id);
}
