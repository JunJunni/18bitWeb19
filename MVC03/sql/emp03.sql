drop table user03;
drop table emp03;
drop sequence user03_seq;
drop sequence emp03_seq;

create table user03(
	num number primary key,
	id varchar2(15),
	pw varchar2(15),
	name varchar2(15)
);

create sequence user03_seq;

create table emp03(
	empno number primary key,
	unum number references user03(num),
	sub varchar2(30),
	content varchar2(2000),
	ddate date,
	cnt number default 0
);
create sequence emp03_seq;

--dummy
insert into user03 values(user03_seq.nextval,'admin','1234','admin');
insert into user03 values(user03_seq.nextval,'root','1234','superviser');
insert into user03 values(user03_seq.nextval,'user01','1234','guest1');

insert into emp03 values(emp03_seq.nextval,'1','test1','test',sysdate,0);
insert into emp03 values(emp03_seq.nextval,'2','test2','test',sysdate,0);
insert into emp03 values(emp03_seq.nextval,'3','test3','test',sysdate,0);
insert into emp03 values(emp03_seq.nextval,'1','test4','test',sysdate,0);
commit;

SELECT empno,(SELECT NAME FROM USER03 WHERE NUM=UNUM) AS "NAME",SUB,CONTENT,DDATE,CNT FROM EMP03;