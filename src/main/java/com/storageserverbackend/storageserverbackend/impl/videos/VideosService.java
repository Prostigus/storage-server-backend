package com.storageserverbackend.storageserverbackend.impl.videos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

import static com.storageserverbackend.storageserverbackend.impl.videos.VideosSpecification.*;


@Service
public class VideosService implements IVideosService {

    @Autowired
    private VideosRepository videosRepository;

    @Override
    public Videos save(Videos video) {
        return videosRepository.save(video);
    }

    @Override
    public Page<Videos> fetchList(List<Integer> people, List<Integer> categories, Boolean fav, Pageable pageable) {
        Specification<Videos> filters = Specification
                .where(CollectionUtils.isEmpty(people) ? null : hasPeople(people))
                .and(CollectionUtils.isEmpty(categories) ? null : hasCategories(categories))
                .and(fav == null ? null : hasFavourite());
        return videosRepository.findAll(filters, pageable);
    }

    @Override
    public Videos fetchById(Integer id) {
        return videosRepository.findById(id).get();
    }

    @Override
    public Videos update(Videos video, Integer id) {
        Videos videoDB = fetchById(id);

        if (Objects.nonNull(video.getDescription())) {
            videoDB.setDescription(video.getDescription());
        }

        if (Objects.nonNull(video.getCategories())) {
            videoDB.setCategories(video.getCategories());
        }

        if (Objects.nonNull(video.getPeople())) {
            videoDB.setPeople(video.getPeople());
        }

        if (videoDB.getFav() != video.getFav()) {
            videoDB.setFav(video.getFav());
        }

        return videosRepository.save(videoDB);
    }

    @Override
    public void delete(Integer id) {
        videosRepository.deleteById(id);
    }

}
