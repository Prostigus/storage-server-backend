package com.storageserverbackend.storageserverbackend.api.controller;

import com.storageserverbackend.storageserverbackend.impl.links.ILinksService;
import com.storageserverbackend.storageserverbackend.impl.links.Links;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LinksController {

    @Autowired
    private ILinksService iLinksService;

    @PostMapping("/link")
    public Links saveLink(@RequestBody Links link) {
        return iLinksService.save(link);
    }

    @GetMapping("/link")
    public Page<Links> getLinks(@RequestParam(required = false) List<Integer> people,
                                @RequestParam(required = false) List<Integer> categories,
                                @RequestParam(required = false) Integer page,
                                @RequestParam(required = false) Boolean fav) {
        if (page == null)
            page = 0;
        page = 0;
        Pageable paging = PageRequest.of(page, 50);
        return iLinksService.fetchList(people, categories, fav, paging);
    }

    @GetMapping("/link/{id}")
    public Links getLink(@PathVariable Integer id) {
        return iLinksService.fetchById(id);
    }

    @PutMapping("/link/{id}")
    public Links updateLink(@PathVariable Integer id, @RequestBody Links link) {
//        if(link.getCategories() != null)
//        link.setCategories(
//                link.getCategories().stream().map(category -> {
//                    return iCategoriesService.fetchById(category.getId());
//                }).collect(Collectors.toSet()));
        return iLinksService.update(link, id);
    }

    @DeleteMapping("link/{id}")
    public void deleteLink(@PathVariable Integer id) {
        iLinksService.delete(id);
    }
}
