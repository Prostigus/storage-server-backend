package com.storageserverbackend.storageserverbackend.impl.enthnicity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;

@Service
public class EthnicityService implements IEthnicityService {

    @Autowired
    private EthnicityRepository ethnicityRepository;

    @Override
    public Ethnicity save(Ethnicity ethnicity) {
        return ethnicityRepository.save(ethnicity);
    }

    public void saveEthnicityFromString(String race){
        Ethnicity ethnicity = new Ethnicity(race);
        ethnicityRepository.save(ethnicity);
    }

    @Override
    public List<Ethnicity> fetchList() {
        return (List<Ethnicity>) ethnicityRepository.findAll();
    }

    @Override
    public Ethnicity fetchById(Integer id) {
        return ethnicityRepository.findById(id).get();
    }

    @Override
    public Ethnicity update(Ethnicity ethnicity, Integer id) {
        Ethnicity ethnicityDB = ethnicityRepository.findById(id).get();

        if (Objects.nonNull(ethnicity.getRace())) {
            ethnicityDB.setRace(ethnicity.getRace());
        }

        return ethnicityRepository.save(ethnicityDB);
    }

    @Override
    public void delete(Integer id) {
        ethnicityRepository.deleteById(id);
    }

}
