package org.asdauroravanchiglia.website.article;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.asdauroravanchiglia.website.article.dto.ArticleCreationDto;
import org.asdauroravanchiglia.website.article.dto.ArticleViewDto;
import org.hibernate.mapping.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Stream;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional;

@Mapper(componentModel = "spring", imports = {List.class, Collectors.class, Optional.class, Collection.class, Stream.class, LocalDateTime.class }, nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ArticleMapper {

    @Mapping(target = "coverImage.id", source = "coverImageId" )
    @Mapping(target = "creationDateTime", expression  = "java( LocalDateTime.now() )")
    Article map (ArticleCreationDto articleDto);

    @Mapping(source = "coverImage.id", target = "coverImageId")
    ArticleViewDto map (Article article);

    List<ArticleViewDto> map (List<Article> articleList);
    
    
}
