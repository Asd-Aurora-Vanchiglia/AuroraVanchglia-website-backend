package org.asdauroravanchiglia.website.groups.dto;

import java.util.List;
import java.util.UUID;

import org.asdauroravanchiglia.website.contact.dto.ContactCreationDto;

import lombok.Data;

@Data
public class GroupUpdateDto {
    private String title;

    private String description;
    private Boolean onMenu;
    private String icon;

    private List<ContactCreationDto> contacts;
}
