package com.storageserverbackend.storageserverbackend.api.controller;

import com.storageserverbackend.storageserverbackend.impl.images.IimagesService;
import com.storageserverbackend.storageserverbackend.impl.images.Images;
import com.storageserverbackend.storageserverbackend.impl.multipart.IMultiPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ImagesController {

    @Autowired
    private IimagesService iimagesService;

    @Autowired
    private IMultiPartService iMultiPartService;

    @PostMapping(path = "/image", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Images saveImage(@RequestPart Images image, @RequestPart("addImage") MultipartFile imageFile)
            throws IOException {
        image = (iMultiPartService.saveToStorage(imageFile, image));
        return iimagesService.save(image);
    }

    @GetMapping("/image")
    public Page<Images> getImagesList(@RequestParam(required = false) List<Integer> people,
                                      @RequestParam(required = false) List<Integer> categories,
                                      @RequestParam(required = false) Integer page,
                                      @RequestParam(required = false) Boolean fav) {
        if (page == null)
            page = 0;
        Pageable paging = PageRequest.of(page, 50);
        return iimagesService.fetchList(people, categories, fav, paging);
    }

    @GetMapping("/image/{id}")
    public Images getImage(@PathVariable Integer id) {
        return iimagesService.fetchById(id);
    }

    @PutMapping("/image/{id}")
    public Images updateImage(@PathVariable Integer id, @RequestBody Images image) {
        return iimagesService.update(image, id);
    }

    @DeleteMapping("/image/{id}")
    public void deleteImage(@PathVariable Integer id) throws IOException {
        iMultiPartService.deleteImageFromStorage(iimagesService.fetchById(id));
        iimagesService.delete(id);
    }
}
