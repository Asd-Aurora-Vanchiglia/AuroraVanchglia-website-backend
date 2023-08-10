package org.asdauroravanchiglia.website.groups;

import java.util.List;
import java.util.UUID;

import org.asdauroravanchiglia.website.common.ListWrapper;
import org.asdauroravanchiglia.website.groups.dto.GroupCreationDto;
import org.asdauroravanchiglia.website.groups.dto.GroupUpdateDto;
import org.asdauroravanchiglia.website.groups.dto.GroupViewDto;
import org.asdauroravanchiglia.website.image.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("groups")
public class GroupController {
    
    @Autowired
    GroupMapper mapper;

    @Autowired
    GroupService service;

    @Autowired
    ImageMapper imageMapper;

    @GetMapping()
    public ListWrapper<GroupViewDto> getAll(){
        List<Group> groups = service.findAll();

        List<GroupViewDto> groupsViews = mapper.map(groups);
        
        return new ListWrapper<>(groupsViews);
    }

    @GetMapping("{id}")
    public GroupViewDto getById(@PathVariable UUID id){
        Group group = service.findById(id);
        return mapper.map(group);
    }

    @GetMapping("withTitle/{title}")
    public GroupViewDto getByTitle(@PathVariable String  title){
        Group group = service.findByTitle(title);
        return mapper.map(group);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public GroupViewDto createGroup(@RequestBody GroupCreationDto creationRequest){
        Group group = service.createGroup(mapper.map(creationRequest));

        return mapper.map(group);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("{id}")
    public GroupViewDto updateGroup(@PathVariable UUID id,@RequestBody GroupUpdateDto updateRequest){
        Group groupToUpdate = mapper.patch(service.findById(id), updateRequest);
        Group group = service.updateGroup(groupToUpdate);
        return mapper.map(group);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "{id}/set-image", produces = {MediaType.APPLICATION_JSON_VALUE})
    public GroupViewDto updateImage(@RequestParam("image") MultipartFile image, @PathVariable UUID id) {
        Group group = service.updateCoverImage(id, imageMapper.map(image));
        
        GroupViewDto transformedDto = mapper.map(group);
        
        return transformedDto;
    }

    
}
