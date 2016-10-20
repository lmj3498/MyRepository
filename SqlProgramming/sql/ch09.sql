--Ch09: 
--Section04 유일한 값만 허용하는 UNIQUE 제약 조건
drop table member;
create table member(
  mid varchar(10) unique not null,
  mname varchar(10) not null,
  mage number(3) null,
  memail char(50) unique null,
  mbirth date null
);

insert into member values('user1','사용자1',25,'user1@sw.com',sysdate);
insert into member values('user2','사용자2',25,'user1@sw.com',sysdate);
insert into member values('user3','사용자3',25,null,sysdate);
insert into member values('user4','사용자4',25,null,sysdate);

--Section06 데이터 구분을 위한 PRIMARY KEY 제약조건
-- UNIQUE+ NOT NULL
-- 한 테이블 당 1개만 설정 가능
-- 행을 구별하는 식별값으로 사용
drop table member;
create table member(
  mid varchar(10) primary key,
  mname varchar(10) not null,
  mage number(3) null,
  memail char(50) null,
  mbirth date null
);
insert into member values('user1','사용자1',25,'user1@sw.com',sysdate);
--Section07 참조 무결성을 위한 FOREIGN KEY 제약조건
--외부 테이블의 PK값만 입력할 수 있도록 함
--관계 설정에서 나오는 키(특정한 테이블의 컬럼이라고 명시되는 것이 아님)
--하나의 테이블의 컬럼이 외부의 PK를 참조하는 것 뿐
--아래의 테이블을 보면, board의 bwriter 가 member의 mid를 참조할 때,
-- bwriter 와 mid 어느것도 FOREIGN KEY가 되는 것이 아니라는 뜻
drop table board;
create table board(
  bno number(10) primary key, 
  btitle varchar(100) not null,
  bcontent varchar(4000) not null, 
  bwriter varchar(10) references member(mid), 
  bhitcount number(5) null, 
  bdate date null 
);
insert into board values(1,'제목1','내용1','user1',0,sysdate);
insert into board values(2,'제목2','내용2','user1',0,sysdate);


--Section08 CHECK 제약조건
drop table board;
drop table member;
create table member(
  mid varchar(10) primary key,
  mname varchar(10) not null,
  mage number(3) check(mage>=0 and mage<150),
  msex varchar(10) check(msex in('남자','여자')),
  memail char(50) null,
  mbirth date null
);
insert into member values('user1','사용자1',25,'남자','user1@sw.com',sysdate);
insert into member values('user2','사용자2',200,'남자','user1@sw.com',sysdate);
insert into member values('user3','사용자3',null,'남자','user1@sw.com',sysdate);
insert into member values('user4','사용자4',26,'안됌','user1@sw.com',sysdate);


--Section09 DEFAULT 제약조건
drop table board;
create table board(
  bno number(10) primary key, 
  btitle varchar(100) not null,
  bcontent varchar(4000) not null, 
  bwriter varchar(10) not null, 
  bhitcount number(5) default 0,
  bkind varchar(15) default '자유',
  bdate date null 
);
insert into board values(1,'제목1','내용1','user1',0,'자유',sysdate);
insert into board values(2,'제목2','내용2','user2','자유',sysdate);--컬럼 수에 맞춰야 함 default와 무관
insert into board values(2,'제목2','내용2','user2',default,'자유',sysdate);
insert into board(bno,btitle, bcontent, bwriter)
values(3,'제목3','내용3','user3');



--Section05 컬럼 레벨로 제약 조건 설정
drop table board;
drop table member;
create table member(
  mid varchar(10) primary key,--컬럼 수준 제약 조건 : 컬럼 설정과 동시에 제약조건 설정
  mname varchar(10) not null
);
drop table member;
create table member(
  mid varchar(10)  constraint pk_member_mid primary key,--컬럼 수준 제약 조건 : 컬럼 설정과 동시에 제약조건 설정
  mname varchar(10) not null
);
drop table member;
create table member(
  mid varchar(10)  constraint pk_member_mid primary key,--컬럼 수준 제약 조건 : 컬럼 설정과 동시에 제약조건 설정
  mage varchar(10) constraint ch_member_mage check(mage>=0 and mage<150)
);
--Section10 테이블 레벨로 제약 조건 설정
drop table member;
create table member(
  mid varchar(10) not null,
  mname varchar(10) not null,
  constraint pk_member_mid primary key(mid)--테이블 수준 제약 조건 : 테이블 설정과 동시에 제약조건 설정
);
drop table member;
create table member(--이런 경우 에러
  ssn1 varchar(6) constraint pk_member_mid primary key,
  ssn2 varchar(7) constraint pk_member_mid primary key,
  mname varchar(10) not null
);
drop table member;
create table member(
  ssn1 varchar(6) not null,
  ssn2 varchar(7) not null,
  mname varchar(10) not null,
  constraint pk_member_mid primary key(ssn1,ssn2)--복합키 : 두 개 이상의 컬럼을 묶어 하나의 primary key로
);
drop table member;
create table member(
  ssn1 varchar(6) not null,
  ssn2 varchar(7) not null, 
  mage number(3) not null, 
  constraint pk_member_mid primary key(ssn1,ssn2),
  constraint ch_member_mage check(mage>=0 and mage<150)
);

--Section11 제약조건 변경하기
--11.1 제약조건 추가하기
--실제 프로그램이 테이블을 만들 때 아래와 같은 코드로 실행
drop table member;
create table member(
  ssn1 varchar(6),
  ssn2 varchar(7), 
  mage number(3)
);
alter table member 
 add constraint pk_member_mid primary key(ssn1,ssn2);

alter table member 
 add constraint ch_member_mage check(mage>=0 and mage<150);

--11.3 제약조건 제거하기
-- 기존의 데이터를 새로운 테이블로 옮길 때
drop table member;
create table member(
  ssn1 varchar(6) not null,
  ssn2 varchar(7) not null, 
  mage varchar(10) not null, 
  constraint pk_member_ssn primary key(ssn1,ssn2),
  constraint ch_member_mage check(mage>=0 and mage<150)
);
alter table member drop primary key;
alter table member drop constraint ch_member_mage;

--Section12 제약조건 비활성화 CASCADE
drop table member;
create table member(
  mid varchar(10)  constraint pk_member_mid primary key,--컬럼 수준 제약 조건 : 컬럼 설정과 동시에 제약조건 설정
  mage varchar(10) constraint ch_member_mage check(mage>=0 and mage<150)
);
drop table board;
create table board(
  bno varchar(10)  constraint pk_board_bno primary key,--컬럼 수준 제약 조건 : 컬럼 설정과 동시에 제약조건 설정
  bwriter varchar(10) constraint fk_board_bwriter references member(mid)
);

--12.1&12.2 제약조건 비활성화& 비활성화
--alter table member disable primary key; --기본 모양
alter table board disable primary key;
alter table board enable primary key;
--12.3 CASCADE
alter table member disable primary key cascade;
alter table member enable primary key;
alter table board enable constraint fk_board_bwriter;


--12.4 ON DELETE CASCADE
drop table member;
create table member(
  mid varchar(10)  constraint pk_member_mid primary key,--컬럼 수준 제약 조건 : 컬럼 설정과 동시에 제약조건 설정
  mage varchar(10) constraint ch_member_mage check(mage>=0 and mage<150)
);
drop table board;
create table board(
  bno varchar(10)  constraint pk_board_bno primary key,--컬럼 수준 제약 조건 : 컬럼 설정과 동시에 제약조건 설정
  bwriter varchar(10) constraint fk_board_bwriter references member(mid) on delete cascade --이 부분 중요
);

insert into member values('user1',25);
insert into board values(1,'user1');
insert into board values(2,'user1');

delete from member where mid='user1'; --이 부분이 가능해짐..



























