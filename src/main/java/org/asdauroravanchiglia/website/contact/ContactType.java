package org.asdauroravanchiglia.website.contact;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum ContactType {
    
    FACEBOOK("facebook"),
    INSTAGRAM("instagram"),
    TELEPHONE("telephone"),
    EMAIL("email");

    @Getter
    private String label;

}
