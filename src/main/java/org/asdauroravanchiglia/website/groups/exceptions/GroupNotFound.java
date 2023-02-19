package org.asdauroravanchiglia.website.groups.exceptions;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GroupNotFound extends RuntimeException {

    private GroupNotFound(String msg){
        super(msg);
    }

    public static GroupNotFound notFoundById(UUID id) {
        return new GroupNotFound(String.format("No Group found for id: '%s'", id.toString()));
    }

    public static GroupNotFound notFoundByTitle(String title) {
        return new GroupNotFound(String.format("No Group found for title: '%s'", title));
    }
    

    
}
