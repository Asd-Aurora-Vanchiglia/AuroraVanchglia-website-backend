package org.asdauroravanchiglia.website.groups.dto;

import java.util.List;

import org.asdauroravanchiglia.website.contact.dto.ContactCreationDto;

import lombok.Data;

@Data
public class GroupCreationDto {
    private String title;

    private String description;
    private Boolean onMenu;

    private List<ContactCreationDto> contacts;
}
