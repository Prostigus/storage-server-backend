package com.storageserverbackend.storageserverbackend.impl.enthnicity;

import java.util.List;


public interface IEthnicityService {
    Ethnicity save(Ethnicity ethnicity);

    void saveEthnicityFromString(String race);

    List<Ethnicity> fetchList();

    Ethnicity fetchById(Integer id);

    Ethnicity update(Ethnicity ethnicity, Integer id);

    void delete(Integer id);
}
