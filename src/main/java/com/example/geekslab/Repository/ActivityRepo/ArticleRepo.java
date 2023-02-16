package com.example.geekslab.Repository.ActivityRepo;

import com.example.geekslab.Entite.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article,Long> {
}
