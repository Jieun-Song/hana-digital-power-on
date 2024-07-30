alter sequence member7_no_seq nocache;

alter sequence member7_no_seq nocycle;

select * from tbl_members7 order by mem_id asc;

select * from tbl_member_roles7 order by fno asc;

-- 스프링 시큐리티 자동로그인 정보를 유지하는 테이블
create table  persistent_logins(
    username varchar2(64) NOT NULL, --회원아이디
    series varchar2(64) PRIMARY KEY, --비번
    token varchar2(64) NOT NULL, --토큰정보
    last_used timestamp NOT NULL -- 로그인한 시간 
);

SELECT * FROM persistent_logins;

