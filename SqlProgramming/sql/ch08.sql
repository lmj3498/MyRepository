--Ch08: 
--      DML(Data Manipulation Language) - 데이터 관련 명령어
--      : 저장(insert), 수정(update), 삭제(delete), 조회(select)
--      DDL(Data Definition Language) - 데이터베이스 객체(Object)와 관련된 명령어
--      : 생성(create), 삭제(drop), 수정(alter)
--      DCL(Data Control Language) - 권한 및 사용자 관련 명령어
--      : 권한할당(grant), 권한삭제(revoke), 작업반영(commit), 작업취소(rollback)

--Section01 테이블에 내용을 추가하는 INSERT 문
insert into member(mid, mname, mage, mbirth) 
values('user3','사용자3',27,'16/02/04');

insert into member(mid, mname) 
values('user4','사용자4');

insert into member 
values('user5','사용자5',27,'16/08/12');

insert into member 
values('user6','사용자6',null,null);

insert into board(bno,btitle,bcontent,bwriter,bhitcount,bdate)
values(4,'제목4','내용4','user4',0,sysdate);

insert into board
values(5,'제목5','내용5','user5',0,sysdate);

insert into board(bno,btitle,bcontent,bwriter)
values(6,'제목6','내용6','user6');


--Section02 테이블에 내용을 수정하는 UPDATE 문
update member set mage = 10 where mid = 'user1';
update member set mage = 20, mbirth = '2001.08.10' where mid = 'user1';
update member set mage = mage+1 where mid = 'user1';

--Section03 테이블에 내용을 삭제하는 DELETE 문
delete member where mid = 'user5';
delete member where mage = 20;


--Section04 트랜잭션 관리
create table account(
  ano varchar(20) not null,
  abalance number(10) null
);
insert into account(ano, abalance) values('111-111',1000000);
insert into account(ano, abalance) values('111-112',0);

--계좌이체: 출금작업 + 입금작업 --> 트랜잭션 작업 = All or Nothing
 --출금작업 
 update account set abalance=abalance-10000 where ano = '111-111';
 --입금작업
 update account set abalance=abalance+10000 where ano = '111-113';
--출금은 성공했으나, 입금이 실패했기 때문에 전체를 실패 처리해야함
rollback;
--출금도 성공했고, 입금도 성공했다면 전체를 영구반영 처리해야함
commit;








