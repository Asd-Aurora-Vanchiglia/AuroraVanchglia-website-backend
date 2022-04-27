package org.asdauroravanchiglia.website.image;

import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "images")
@Entity
@Data
public class Image {


    @Id 
    @GeneratedValue
    private UUID id;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] content;

    private String contenType;
    private Long size;
    private String name;

    
    
}
