package com.example.geekslab.Service.Activity;

import com.example.geekslab.Entite.Article;
import com.example.geekslab.Entite.Claim;
import com.example.geekslab.IService.IArticleService;
import com.example.geekslab.Repository.ActivityRepo.ArticleRepo;

import java.util.List;

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

    }
}
