CREATE TABLE tbl_reply(
    rno NUMBER(38) PRIMARY KEY,
    bno NUMBER(38) DEFAULT 0,
    --게시판 번호값이 저장되는 컬럼,
    --외래키 제약조건으로 추가설정, tbl_board테이블의
    --게시물 번호값만 저장
    replyer varchar2(100) NOT NULL,--댓글 작성자
    replytext VARCHAR2(4000) NOT NULL, -- 댓글내용
    regdate DATE, --등록날짜
    updatedate DATE --수정날짜 
);

SELECT * FROM tbl_reply ORDER BY rno desc;

--bno 컬럼 외래기 추가 설정
ALTER TABLE tbl_reply ADD CONSTRAINT tbl_reply_bno_fk FOREIGN KEY(bno) REFERENCES tbl_board(bno);

--rno_seq 댓글 시퀀스 생성
CREATE SEQUENCE rno_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

--rno_seq 시퀀스 다음번호값 확인
SELECT rno_seq.nextval as "다음시퀀스번호값" FROM dual;

--dual테이블은 오라클 설치시 자동으로 깔리는 임시테이블... 컬럼이 하나..
-- 시퀀스 값 확인용도로 사용함 

SELECT sysdate as "오늘날짜시간값" from dual;