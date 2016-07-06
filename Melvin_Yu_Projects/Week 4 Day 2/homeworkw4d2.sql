select * from emp where sal>3000;--1

select * from emp where ename like 'S%';--2

select * from emp where ename in ('SMITH','ALLEN','FORD');--3

select a.*, b.dname as department from emp a, dept b where a.deptno=b.deptno and b.dname='SALES';--4

select  b.deptno, avg(sal),min(sal),max(sal),sum(sal) from emp a full outer join dept b  on b.deptno=a.deptno  group by b.deptno order by b.deptno;--5

select  b.dname, count(sal) from emp a, dept b  where a.deptno=b.deptno and a.sal>3000 group by dname;--6

select  b.dname, avg(a.sal) from emp a full outer join dept b  on b.deptno=a.deptno group by dname order by dname asc;--7

select  b.deptno,a.sal, count(a.ename) from emp a, dept b , emp c  where a.deptno=b.deptno and a.sal=c.sal and a.empno!=c.empno group by b.deptno, a.sal;--8

select a.dname,a.loc, count(b.ename) from dept a, emp b where a.deptno = b.deptno having count(b.ename)>2 group by a.dname, a.loc;--9

select * from emp where sal > (select avg(sal) from emp);--10
