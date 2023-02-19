package org.asdauroravanchiglia.website.contact.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Valid
public class ContactCreationDto {

    @NotEmpty
    private String type;
    @NotEmpty
    private String value;
    
}
