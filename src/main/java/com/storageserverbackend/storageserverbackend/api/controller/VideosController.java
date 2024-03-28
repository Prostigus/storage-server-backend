package com.storageserverbackend.storageserverbackend.api.controller;

import com.storageserverbackend.storageserverbackend.impl.multipart.IMultiPartService;
import com.storageserverbackend.storageserverbackend.impl.videos.IVideosService;
import com.storageserverbackend.storageserverbackend.impl.videos.Videos;
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
public class VideosController {

    @Autowired
    private IVideosService iVideoService;

    @Autowired
    private IMultiPartService iMultiPartService;

    @PostMapping(path = "/video", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Videos saveVideo(@RequestPart Videos video, @RequestPart("addVideo") MultipartFile videoFile)
            throws IOException {
        video = (iMultiPartService.saveToStorage(videoFile, video));
        return iVideoService.save(video);
    }

    @GetMapping("/video")
    public Page<Videos> getVideoList(@RequestParam(required = false) List<Integer> people,
                                     @RequestParam(required = false) List<Integer> categories,
                                     @RequestParam(required = false) Integer page,
                                     @RequestParam(required = false) Boolean fav) {
        if (page == null)
            page = 0;
        Pageable paging = PageRequest.of(page, 50);
        return iVideoService.fetchList(people, categories, fav, paging);
    }

    @GetMapping("/video/{id}")
    public Videos getVideo(@PathVariable String id) {
        return iVideoService.fetchById(Integer.parseInt(id));
    }

    @PutMapping("/video/{id}")
    public Videos updateVideo(@PathVariable Integer id, @RequestBody Videos video) {
        return iVideoService.update(video, id);
    }

    @DeleteMapping("/video/{id}")
    public void updateVideo(@PathVariable Integer id) throws IOException {
        iMultiPartService.deleteVideoFromStorage(iVideoService.fetchById(id));
        iVideoService.delete(id);
    }
}
