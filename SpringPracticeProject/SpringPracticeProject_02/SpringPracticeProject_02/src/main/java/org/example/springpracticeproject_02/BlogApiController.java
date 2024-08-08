package org.example.springpracticeproject_02;

import lombok.RequiredArgsConstructor;
import org.example.springpracticeproject_02.service.BlogService;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController //HTTP Response Body에 객체 데이터를 JSON형식으로 반환하는 컨트롤러
public class BlogApiController {

    private final BlogService blogService;

    //

}
