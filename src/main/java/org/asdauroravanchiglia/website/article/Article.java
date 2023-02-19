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
    protected UUID id;
    protected String title;
    protected String content;
    protected LocalDateTime creationDateTime;
    protected LocalDateTime updateDateTime;
    @OneToOne
    protected Image coverImage;
}
