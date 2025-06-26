SELECT Department,Employee,Salary From (SELECT d.name as Department,e.name as Employee,e.salary as Salary,DENSE_RANK() OVER(PARTITION BY departmentId ORDER BY salary DESC) AS ranked FROM Employee e JOIN Department d ON e.departmentId=d.id) AS alia Where ranked<=3;

