package com.storageserverbackend.storageserverbackend.impl.multipart;

import com.storageserverbackend.storageserverbackend.impl.images.Images;
import com.storageserverbackend.storageserverbackend.impl.videos.Videos;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class MultiPartService implements IMultiPartService {

    @Value("${spring.boot.storagepath}")
    String storagePath;

    public Images saveToStorage(MultipartFile file, Images image) throws IOException {
        UUID uuid = UUID.randomUUID();
        String fileName = file.getOriginalFilename();
        int e = fileName.lastIndexOf(".");
        String extension = fileName.substring(e + 1);
        String backendPath = processFilePathBasedOnType(extension);
        Path uploadPath = Path.of(storagePath).resolve(backendPath);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Files.copy(file.getInputStream(), uploadPath.resolve(uuid.toString() + "." + extension),
                StandardCopyOption.REPLACE_EXISTING);
        image.setUUID(uuid);
        image.setDescription(fileName);
        image.setUploadPath(backendPath);
        image.setExtension(extension);
        return image;
    }

    public void deleteImageFromStorage(Images image) throws IOException {
        Files.delete(Path.of(storagePath).resolve(image.getUploadPath()).resolve(image.getUUID().toString() + "." + image.getExtension()));
    }


    public Videos saveToStorage(MultipartFile file, Videos video) throws IOException {
        UUID uuid = UUID.randomUUID();
        String fileName = file.getOriginalFilename();
        int e = fileName.lastIndexOf(".");
        String extension = fileName.substring(e + 1);
        String backendPath = processFilePathBasedOnType(extension);
        Path uploadPath = Path.of(storagePath).resolve(backendPath);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Files.copy(file.getInputStream(), uploadPath.resolve(uuid.toString() + "." + extension),
                StandardCopyOption.REPLACE_EXISTING);
        video.setUUID(uuid);
        video.setDescription(fileName);
        video.setUploadPath(backendPath);
        video.setExtension(extension);
        return video;
    }

    public void deleteVideoFromStorage(Videos video) throws IOException {
        Files.delete(Path.of(storagePath).resolve(video.getUploadPath()).resolve(video.getUUID().toString() + "." + video.getExtension()));
    }

}
