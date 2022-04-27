package org.asdauroravanchiglia.website.article;

import java.util.List;
import java.util.UUID;

import org.asdauroravanchiglia.website.article.dto.ArticleCreationDto;
import org.asdauroravanchiglia.website.article.dto.ArticleViewDto;
import org.asdauroravanchiglia.website.common.ListWrapper;
import org.asdauroravanchiglia.website.image.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    ArticleService service;

    @Autowired
    ArticleMapper mapper;

    @Autowired
    ImageMapper imageMapper;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ListWrapper<ArticleViewDto> getAll() {

        List<Article> listArticles = service.getAllArticles();

        List<ArticleViewDto> transformedListDto = mapper.map(listArticles);
        return new ListWrapper<>(transformedListDto);
    }

    @GetMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ArticleViewDto get(@PathVariable("id") UUID id) {

        Article article = service.getArticleById(id);
        
        ArticleViewDto transformedDto = mapper.map(article);
        
        return transformedDto;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE} )
    public void delete(@PathVariable("id") UUID id) {

        service.delete(id);
    
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ArticleViewDto create(@RequestBody ArticleCreationDto articleDto) {
              
        Article articleToSave = mapper.map(articleDto);

        Article savedArticle = service.save(articleToSave);
        
        ArticleViewDto transformedDto = mapper.map(savedArticle);
        
        return transformedDto;
    }
    
}
