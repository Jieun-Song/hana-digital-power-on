package org.example.springpracticeproject.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "member9_no_seq_gename",
                    sequenceName = "member9_no_seq",
                    initialValue = 1,
                    allocationSize = 1)
@Table(name = "tbl_member9_roles")
@EqualsAndHashCode(of = "fno")
@ToString
public class MemberRole {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member9_no_seq_gename")
    private int fno;

    private String roleName;
}
