package org.asdauroravanchiglia.website.contact;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.asdauroravanchiglia.website.contact.dto.ContactCreationDto;
import org.asdauroravanchiglia.website.contact.dto.ContactViewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", imports = {List.class, Collectors.class, Optional.class, Collection.class, Stream.class, LocalDateTime.class }, nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ContactMapper {

    @Mapping(target = "type", source="type")
    Contact map(ContactCreationDto dto);

    List<Contact> map(List<ContactCreationDto> dtos);


    @Mapping(target = "type", source="type.label")
    ContactViewDto map(Contact entity);

    List<ContactViewDto> mapToView(List<Contact> entities);

    
}
