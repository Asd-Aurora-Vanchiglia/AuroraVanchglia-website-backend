package org.asdauroravanchiglia.website.groups.dto;

import java.util.List;
import java.util.UUID;

import org.asdauroravanchiglia.website.contact.Contact;

import lombok.Data;

@Data
public class GroupViewDto {

    private UUID id;

    private String title;
    private String titleLinkParsed;

    private String description;
    private Boolean onMenu;

    private String icon;

    private UUID coverImageId;

    private List<Contact> contacts;
}
