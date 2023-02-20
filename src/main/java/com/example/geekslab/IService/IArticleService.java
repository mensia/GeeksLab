package com.example.geekslab.IService;

import com.example.geekslab.Entite.Article;
import com.example.geekslab.Entite.Claim;

import java.util.List;

public interface IArticleService {


    List<Article> GetallArticle();
    public Article AddArticle(Article article);
    public Article findArticlebyId(Long id) ;

    void delete(long id);
}
