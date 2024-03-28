package com.storageserverbackend.storageserverbackend.impl.videos;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VideosRepository extends CrudRepository<Videos, Integer>, JpaSpecificationExecutor<Videos> {

}
