package org.example.project1.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //DB가 알아서 생성해줌(indetity)
    private Long id;//데이터를 저장하기 위해 시스템이 정하는 값

    private String name; //그냥 이름

}
