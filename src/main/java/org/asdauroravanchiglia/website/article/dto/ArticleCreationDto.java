package org.asdauroravanchiglia.website.article.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class ArticleCreationDto {
 
    private String content;
    private String title;
    private UUID coverImageId;
    
}
