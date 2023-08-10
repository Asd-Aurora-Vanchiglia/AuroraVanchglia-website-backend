package org.asdauroravanchiglia.website.image;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    
    @Autowired
    ImageRepository repo;

    @Autowired
    ImageMapper mapper;


    @Transactional
    public Image storeImage(Image imageToSave){
        Image savedImage = repo.save(imageToSave);
        return savedImage;
    }

    @Transactional
    public Image getImageById(UUID id){
        Image savedImage = repo.findById(id).get();
        return savedImage;
    }

}
