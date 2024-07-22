package org.example.project1.domain;

public class Member {

    private Long id;//데이터를 저장하기 위해 시스템이 정하는 값
    private String name; //그냥 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
