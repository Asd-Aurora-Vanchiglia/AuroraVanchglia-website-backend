package org.asdauroravanchiglia.website.article.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class ArticleViewDto {
    

    private UUID id;
    private String title;
    private String content;
    private LocalDateTime creationDateTime;
    private LocalDateTime updateDateTime;
    private UUID coverImageId;
    
}
