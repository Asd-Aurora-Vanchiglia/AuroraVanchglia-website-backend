package org.asdauroravanchiglia.website.contact.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class ContactViewDto {

    private UUID id;
    private String type;
    private String value;
    
}
