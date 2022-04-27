package org.asdauroravanchiglia.website.image;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("images")
public class ImageController {
    
    @Autowired
    ImageService service;

    @Autowired
    ImageMapper mapper;


    @GetMapping(value="{id}")
    public ResponseEntity<?> getMethodName(@PathVariable("id") UUID id) {
        Image image = service.getImageById(id);

        ResponseEntity<?> response = mapper.map(image);

        return response;
    }

    @PostMapping(value="",  consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public UUID getMethodName(@RequestPart MultipartFile imageFile) {


        Image imageToSave = mapper.map(imageFile);
        Image savedImage = service.storeImage(imageToSave);


        return savedImage.getId();
    }
    



}
