select rownum, bno, btitle
from (select bno, btitle from board order by bno);

--행 순번 5개 붙이기
--최근 삽입된 행 5개 가져오기
select rownum, bno, btitle
from (select bno, btitle from board order by bno desc)
where rownum<=5;

--밑에는 불가
select rownum, bno, btitle
from (select bno, btitle from board order by bno desc)
where rownum>5000;

--행의 순번이 11번~20번
select rn, bno, btitle
from(
  select rownum as rn, bno, btitle
  from(select bno, btitle from board order by bno desc)
  where rownum<=20
)
where rn>=11;

--1페이지에 10개씩 구성하고, n번째 페이지를 가져와라
select rn, bno, btitle
from(
  select rownum as rn, bno, btitle
  from(select bno, btitle from board order by bno desc)
  where rownum<=(n*10)
)
where rn>=(n-1)*10+1;








