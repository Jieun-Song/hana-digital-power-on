package org.example.project1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.project1.Service.MemberService;
import org.example.project1.domain.Member;
import org.example.project1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import javax.sql.DataSource;
import javax.swing.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

}
