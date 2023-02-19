package org.asdauroravanchiglia.website.contact;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.asdauroravanchiglia.website.common.ListWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contacts")
public class ContactController {

    @GetMapping("types")
    public ListWrapper<String> getTypes() {
        List<String> typeList =  Stream.of(ContactType.values()).map((type) -> type.getLabel().toUpperCase()).collect(Collectors.toList());
        return new ListWrapper<>(typeList);
    }

}
