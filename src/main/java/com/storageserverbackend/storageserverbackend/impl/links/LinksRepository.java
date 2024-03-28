package com.storageserverbackend.storageserverbackend.impl.links;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LinksRepository extends CrudRepository<Links, Integer>, JpaSpecificationExecutor<Links> {

}
