# Write your MySQL query statement below
SELECT eu.unique_id,e.name FROM Employees e LEFT JOIN EmployeeUNI eU ON e.id=eu.id;
