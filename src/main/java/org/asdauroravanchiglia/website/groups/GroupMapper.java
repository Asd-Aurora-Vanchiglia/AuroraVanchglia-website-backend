package org.asdauroravanchiglia.website.groups;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.asdauroravanchiglia.website.contact.ContactMapper;
import org.asdauroravanchiglia.website.groups.dto.GroupCreationDto;
import org.asdauroravanchiglia.website.groups.dto.GroupUpdateDto;
import org.asdauroravanchiglia.website.groups.dto.GroupViewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", imports = {List.class, Collectors.class, Optional.class, Collection.class, Stream.class, LocalDateTime.class }, nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE, uses = ContactMapper.class)
public interface GroupMapper {

    @Mapping(target = "logo", source = "icon")
    Group map(GroupCreationDto dto);


    @Mapping(target = "icon", source = "logo")
    @Mapping(target = "coverImageId", source = "coverImage.id")
    @Mapping(target = "titleLinkParsed", expression="java(entity.getTitle().toLowerCase().trim().replaceAll(\" \", \"-\"))")
    GroupViewDto map(Group entity);

    Group patch(@MappingTarget Group olGroup, GroupUpdateDto dto);

    List<GroupViewDto> map(List<Group> entities);

    
}
