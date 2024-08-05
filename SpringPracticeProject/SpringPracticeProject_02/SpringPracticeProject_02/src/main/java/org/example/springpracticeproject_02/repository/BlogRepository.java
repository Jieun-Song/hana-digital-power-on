package org.example.springpracticeproject_02.repository;

import org.example.springpracticeproject_02.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
