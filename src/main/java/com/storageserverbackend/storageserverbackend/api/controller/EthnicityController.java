package com.storageserverbackend.storageserverbackend.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storageserverbackend.storageserverbackend.impl.enthnicity.Ethnicity;
import com.storageserverbackend.storageserverbackend.impl.enthnicity.IEthnicityService;

@RestController
public class EthnicityController {
    @Autowired private IEthnicityService ethnicityService;

    @GetMapping("/ethnicity")
    public List<Ethnicity> getEthnicityList() {
        return ethnicityService.fetchList();
    }
}
