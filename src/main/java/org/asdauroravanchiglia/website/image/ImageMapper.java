package org.asdauroravanchiglia.website.image;

import java.io.IOException;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageMapper {

    public Image map(MultipartFile imageFile) {
        Image image = new Image();
        try {
            image.setContent(imageFile.getBytes());
            image.setContenType(imageFile.getContentType());
            image.setSize(imageFile.getSize());
            image.setName(imageFile.getName());
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
        return image;
    }

    public ResponseEntity<?> map (Image image){

        ByteArrayResource resource = new ByteArrayResource(image.getContent());

        MediaType mediaType = MediaType.valueOf(image.getContenType());

        return ResponseEntity.ok()
        // Content-Disposition
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + image.getName())
        // Content-Type
        .contentType(mediaType)
        // Contet-Length
        .contentLength(image.getSize()) //
        .body(resource);

    }


    
}
