package org.asdauroravanchiglia.website.groups.dto;

import java.util.List;
import java.util.UUID;

import org.asdauroravanchiglia.website.contact.Contact;

import lombok.Data;

@Data
public class GroupViewDto {

    private UUID id;

    private String title;

    private String description;
    private Boolean onMenu;

    private UUID coverImageId;

    private List<Contact> contacts;
}
