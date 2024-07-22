--tbl_member 테이블 생성
CREATE TABLE tbl_member(
	userid varchar2(25) PRIMARY KEY --회원아이디 
	,userpw varchar2(50) NOT NULL --회원비번
	,username varchar2(20) NOT NULL --회원이름
	,email varchar2(50) --회원이메일
	,regdate date --가입날짜 
);

SELECT * FROM TBL_MEMBER ORDER BY userid ASC;

--tbl_board 게시판 테이블 생성
--관리자 답변글 기능, 어쩌구는 나중에소스로주실거임
CREATE TABLE tbl_board(
	bno number(38) PRIMARY KEY --게시판번호 
	,writer VARCHAR(50) NOT NULL --글쓴이
	,title VARCHAR(200) NOT NULL -- 글제목
	,content VARCHAR(4000) NOT NULL --글내용
	,viewcnt INT default 0 -- default 0 제약 조건을 설정하면 해당 컬럼에 굳이 레코드를 저장하지 않아도 기본값0이 저장된다.
	,regdate date --등날
	
);

SELECT * FROM tbl_board ORDER BY bno DESC; -- 번호를 기준으로 내림차순 정렬

--번호발생기 시퀀스 생성 
CREATE sequence bno_seq -- bno_seq시퀀스 생성
start WITH 1 -- 1부터 시작
increment BY 1 -- 1씩 증가
nocache -- 시퀀스 값을 미리 메모리에 캐시하지 앟고, 매번 시퀀스 값을 요청할때마다 디스크에서 가져오게 됨을 의미
nocycle; --시퀀스 최대값 생성시 생성 중지해서처음부터 반복 하지않게 하는것  

--생성된 시퀀스번호값 확인 ->시퀀스명.nextval
SELECT bno_seq.nextval FROM dual;