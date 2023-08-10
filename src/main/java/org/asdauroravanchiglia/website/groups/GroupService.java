package org.asdauroravanchiglia.website.groups;

import java.util.List;
import java.util.UUID;

import org.asdauroravanchiglia.website.article.Article;
import org.asdauroravanchiglia.website.contact.Contact;
import org.asdauroravanchiglia.website.contact.ContactRepository;
import org.asdauroravanchiglia.website.groups.exceptions.GroupNotFound;
import org.asdauroravanchiglia.website.image.Image;
import org.asdauroravanchiglia.website.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    GroupRepository repo;

    @Autowired
    ImageService imageService;

    @Autowired
    ContactRepository contactRepo;


    public List<Group> findAll(){
        return repo.findAll();
    }


    public Group findByTitle(String title) {
        return repo.findByTitle(title)
        .orElseThrow( () -> GroupNotFound.notFoundByTitle(title));
    }
    
    public Group findById(UUID id){
        return repo.findById(id).orElseThrow(() -> GroupNotFound.notFoundById(id));
    }

    public Group createGroup(Group groupToSave) {
        if(groupToSave.getContacts() != null && !groupToSave.getContacts().isEmpty()){
            groupToSave.setContacts(contactRepo.saveAll(groupToSave.getContacts()));
        }
        return repo.save(groupToSave);
    }

    public Group updateGroup(Group groupToSave) {
        return repo.save(groupToSave);
    }

    public Group delete(UUID id){
        Group group = repo.findById(id)
            .orElseThrow(() -> GroupNotFound.notFoundById(id));

        contactRepo.deleteAll(group.getContacts());

        repo.delete(group);

        return group;
    }

    public Group updateCoverImage(UUID groupId, Image image){
        Group group = repo.findById(groupId)
            .orElseThrow(() -> GroupNotFound.notFoundById(groupId));

        
        Image savedImage = imageService.storeImage(image);
        group.setCoverImage(savedImage);

        Group savedGroup = repo.save(group);
        return savedGroup;
    }
}
