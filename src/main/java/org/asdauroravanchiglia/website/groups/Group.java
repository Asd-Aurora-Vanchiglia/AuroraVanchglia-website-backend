package org.asdauroravanchiglia.website.groups;

import java.util.List;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.asdauroravanchiglia.website.contact.Contact;
import org.asdauroravanchiglia.website.image.Image;

import lombok.Data;

@Table(name = "groups")
@Data
@Entity
public class Group {

    
    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true)
    private String title;

    @Column(length = 100000)
    private String description;
    private Boolean onMenu;
    private String  logo;

    @OneToOne
    @Basic(fetch=FetchType.LAZY, optional=true)
    private Image coverImage; 

    @OneToMany
    private List<Contact> contacts;
    
}
