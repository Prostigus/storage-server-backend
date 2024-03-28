package com.storageserverbackend.storageserverbackend.impl.multipart;

import com.storageserverbackend.storageserverbackend.impl.images.Images;
import com.storageserverbackend.storageserverbackend.impl.videos.Videos;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public interface IMultiPartService {

    public Images saveToStorage(MultipartFile imageFile, Images image) throws IOException;

    public void deleteImageFromStorage(Images image) throws IOException;

    public Videos saveToStorage(MultipartFile file, Videos video) throws IOException;

    public void deleteVideoFromStorage(Videos video) throws IOException;


    default String processFilePathBasedOnType(String extension) {
        List<String> imageExtensions = Arrays.asList("jpeg", "png", "jpg");
        List<String> gifsExtensions = Arrays.asList("gif", "gifv");
        List<String> webmExtensions = List.of("webm");
        List<String> videoExtensions = Arrays.asList("mov", "mkv", "flv", "vob", "avi", "qt", "wmv", "rm", "rmvb",
                "viv", "mp4", "m4v", "mpg", "mp2", "mpeg", "mpe", "mpv", "3gp", "3g2");

        String path = null;
        extension = extension.toLowerCase();
        if (imageExtensions.contains(extension)) {
            path = "images";
        } else if (gifsExtensions.contains(extension)) {
            path = "gifs";
        } else if (webmExtensions.contains(extension)) {
            path = "webms";
        } else if (videoExtensions.contains(extension)) {
            path = "videos";
        } else {
            path = "unknown";
        }

        return path;
    }

    ;

}