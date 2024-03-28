package com.storageserverbackend.storageserverbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class StorageserverbackendApplication {


    public static void main(String[] args) {
        SpringApplication.run(StorageserverbackendApplication.class, args);

    }

}
