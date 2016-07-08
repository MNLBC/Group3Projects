--1
SELECT * FROM EMP WHERE SAL > 3000;
--2
SELECT * FROM EMP WHERE ENAME LIKE 'S%';
--3
SELECT * FROM EMP WHERE ENAME IN ('SMITH','ALLEN','FORD');
--4
SELECT * FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');
--5
SELECT DEPTNO, AVG(SAL) AS AVERAGE, MAX(SAL) AS BIGGEST, MIN(SAL) AS SMALLEST FROM EMP GROUP BY DEPTNO;
--6
SELECT COUNT(DEPTNO) AS EMPLOYEES, DEPTNO FROM EMP WHERE SAL > 3000 GROUP BY DEPTNO;
--7
SELECT DEPT.DNAME, AVG(EMP.SAL) FROM EMP INNER JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO GROUP BY DEPT.DNAME ORDER BY DNAME ASC;
--8
SELECT E1.SAL AS SALARY, COUNT(E1.DEPTNO) AS EMPLOYEES, E1.DEPTNO FROM EMP E1, EMP E2 WHERE E1.SAL = E2.SAL AND E1.ENAME != E2.ENAME GROUP BY E1.DEPTNO, E1.SAL;
--9
SELECT D.DNAME, D.LOC, COUNT(E.ENAME) AS EMPLOYEES FROM EMP E INNER JOIN DEPT D ON E.DEPTNO = D.DEPTNO GROUP BY D.DEPTNO, D.DNAME, D.LOC;
--10
SELECT ENAME, SAL FROM EMP WHERE SAL > (SELECT AVG(SAL) FROM EMP);