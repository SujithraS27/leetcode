# Write your MySQL query statement below
select
(select distinct Salary 
from Employee order by salary desc 
limit 1 OFFSET 1 ) 
as SecondHighestSalary;
