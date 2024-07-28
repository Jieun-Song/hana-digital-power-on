alter sequence fno_seq nocache; -- nocache로 수정

alter sequence fno_seq nocache; -- 최대값 시퀀스 번호
-- 생성시 생성 중지해서 다시 처음부터 반복 안하게됨



truncate table tbl_boards3;

CREATE TABLE tbl_profile3(
    fno PRIMARY KEY    
);

-- tbl_profile3 테이블 생성
CREATE TABLE tbl_profile4 (
    fno NUMBER PRIMARY KEY, -- 기본 키
    fname VARCHAR2(255), -- fname 컬럼
    current2 
    NUMBER(1), -- current2 컬럼 (BOOLEAN 타입 대신 NUMBER(1)을 사용)
    member_uid2 VARCHAR2(255) -- member_uid2 컬럼 (외래 키)
);

ALTER TABLE tbl_profile4
ADD CONSTRAINT fk_member_uid2
FOREIGN KEY (member_uid2) REFERENCES tbl_members6(uid2);

-- fno_seq1 시퀀스 생성
CREATE SEQUENCE fno_seq4
START WITH 1 -- 시작 값
INCREMENT BY 1; -- 증가 값

-- 트리거 생성
CREATE OR REPLACE TRIGGER trg_fno_profile4
BEFORE INSERT ON tbl_profile4
FOR EACH ROW
BEGIN
  :NEW.fno := fno_seq4.NEXTVAL;
END;

