package org.example.springpracticeproject_02.service;

import lombok.RequiredArgsConstructor;
import org.example.springpracticeproject_02.domain.Article;
import org.example.springpracticeproject_02.dto.AddArticleRequest;
import org.example.springpracticeproject_02.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //블로그 글 추가 매서드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
}
