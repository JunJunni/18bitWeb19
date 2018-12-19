
create table emp02(
 empno number primary key,
 name varchar2(15),
 ddate date,
 pay number,
 cnt number(5) default 0
);

create sequence emp02_seq;

--dummy
insert into emp02 values(emp02_seq.nextval,'test1',sysdate,1000,0);
insert into emp02 values(emp02_seq.nextval,'test2',sysdate,2000,0);
insert into emp02 values(emp02_seq.nextval,'test3',sysdate,3000,0);
insert into emp02 values(emp02_seq.nextval,'test4',sysdate,4000,0);

commit;

select * from emp02;