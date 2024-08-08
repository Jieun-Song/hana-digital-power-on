package org.example.springpracticeproject_02.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springpracticeproject_02.domain.Article;

//DTO : data transfer object 계층끼리 데이터를 교환하기 위해 사용하는 객체(수정x)
    //<-> DAO : data access object 데이터와 연결되고 데이터를 수정하는데 사용.(수정ㅇ)
@NoArgsConstructor//기본 생성자 추가
@AllArgsConstructor//모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity(){ //생성자를 사용해 객체 생성
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }

}
