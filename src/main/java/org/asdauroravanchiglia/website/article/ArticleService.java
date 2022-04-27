package org.asdauroravanchiglia.website.article;

import java.util.List;
import java.util.UUID;

import org.asdauroravanchiglia.website.article.exception.ArticleNotFound;
import org.asdauroravanchiglia.website.image.Image;
import org.asdauroravanchiglia.website.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository repo;

    @Autowired
    ImageService imageService;

    public Article save(Article articleToSave) {
        
        if (null != articleToSave.getCoverImage()) {
            Image savedImage = imageService.storeImage(articleToSave.getCoverImage());
            articleToSave.setCoverImage(savedImage);
        }

        Article savedArticle = repo.save(articleToSave);
        return savedArticle;
    }

    public List<Article> getAllArticles() {
        return repo.findAll();
    }

    public Article getArticleById(UUID id) {
        return repo.findById(id).orElseThrow(() -> new ArticleNotFound(id));
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

}
