package com.example.geekslab.Service.Activity;

import com.example.geekslab.Entite.Article;
import com.example.geekslab.Entite.Claim;
import com.example.geekslab.IService.IArticleService;
import com.example.geekslab.Repository.ActivityRepo.ArticleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class ArticleService implements IArticleService {

    ArticleRepo rep;
    @Override
    public List<Article> GetallArticle() {
        return rep.findAll() ;
    }

    @Override
    public Article AddArticle(Article article) {
        return  rep.save(article);
    }

    @Override
    public void delete(long id) {
        rep.deleteById(id);
    }

    @Override
    public Article findArticlebyId(Long id) {
        return rep.findById(id).orElse(null);
    }


    public Article updateArticle(Long id, Article article) {

        Article oldArticle = rep.findById(id).orElse(null);
        oldArticle.setDescription(oldArticle.getDescription());
        return rep.save(oldArticle);
    }

}
