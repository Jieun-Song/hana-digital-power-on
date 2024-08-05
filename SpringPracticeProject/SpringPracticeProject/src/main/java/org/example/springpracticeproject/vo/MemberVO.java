package org.example.springpracticeproject.vo;

import jdk.jfr.Enabled;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_member9")
@EqualsAndHashCode(of = "mem_id")
public class MemberVO {
    @Id
    private String mem_id;

    private String mem_pwd;
    private String mem_name;
    @OneToMany
    @JoinColumn(name="member")
    private List<MemberRole> roles;
}
