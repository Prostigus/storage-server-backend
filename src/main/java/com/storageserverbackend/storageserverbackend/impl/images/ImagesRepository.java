package com.storageserverbackend.storageserverbackend.impl.images;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImagesRepository extends CrudRepository<Images, Integer>, JpaSpecificationExecutor<Images> {
}
