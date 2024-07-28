SELECT * FROM board ORDER BY board_no DESC;

CREATE SEQUENCE board_no_seq
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;

SELECT board_no_seq.nextval "다음 시퀀스 번호" FROM dual;