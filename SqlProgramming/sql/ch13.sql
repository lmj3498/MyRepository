--Section01 시퀕스 생성
create sequence seq_1;
--다음 수 얻기
select seq_1.nextval from dual;
--현재 부여된 번호
--현재 연결에서의 최근 부여 값
select seq_1.currval from dual; 

create sequence seq_2
  start with 101
  increment by 10
  maxvalue 1000
  nocycle
  nocache;
--다음 수 얻기
select seq_2.nextval from dual;
--현재 부여된 번호
--현재 연결에서의 최근 부여 값
select seq_2.currval from dual; 

drop sequence seq_1;
drop sequence seq_2;

--Section04 인덱스 개요 : 빨리 조회(검색)하기 위해서 : where절에 있는 데이터를
--Primary key or unique 제약조건으로 컬럼만들면 자동으로 인덱스 생성됨
--인덱스도 하나의 저장공간을 저장하기 때문에 성능에 완전 정비례하지 않음
--(저장효율이 떨어짐)(테이블 크기와 인덱스 크기는 정비례 하므로)
--where절의 조건으로 자주쓰이는 검색 기준 컬럼에 주로 사용함
set timing on; --시간 체크
select * from board where btitle='테스트3333';

create index idx_board_btitle on board(btitle);--중복을 허용하는 컬럼에 만듬
drop index idx_board_btitle;

select * from board where bno='9333';
create unique index seq_board_bno on board(bno);--중복을 허용하지 않는 컬럼에 만듬





