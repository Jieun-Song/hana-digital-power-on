package org.example.practice.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardVO {

    private int bno;
    private String writer;
    private String title;
    private String content;
    private int viewcnt;
    private String regdate;
}
