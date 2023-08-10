package org.asdauroravanchiglia.website.event;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.asdauroravanchiglia.website.article.Article;

import com.google.maps.model.LatLng;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(name = "Events")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Event extends Article{

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private LatLng coordinates;
    
}
