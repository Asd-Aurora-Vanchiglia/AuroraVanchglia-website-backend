package org.asdauroravanchiglia.website.article;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.asdauroravanchiglia.website.image.Image;

import lombok.Data;

@Table(name = "articles")
@Entity
@Data
public class Article {

    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String content;
    private LocalDateTime creationDateTime;
    private LocalDateTime updateDateTime;
    @OneToOne
    private Image coverImage;
}
