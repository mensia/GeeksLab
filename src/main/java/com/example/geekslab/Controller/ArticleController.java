package com.example.geekslab.Controller;

import com.example.geekslab.Entite.Article;
import com.example.geekslab.Entite.Claim;
import com.example.geekslab.IService.IArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ArticleController {

    IArticleService serv;


    @GetMapping("/list-article")
    public List<Article> GetallArticle(){
        return serv.GetallArticle();
    }

    @PostMapping("/add-article")
    public Article AddArticle(@RequestBody Article article) {
       return serv.AddArticle(article);
    }

}
