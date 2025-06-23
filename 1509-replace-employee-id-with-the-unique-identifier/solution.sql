# Write your MySQL query statement below
SELECT UNIQUE_ID,NAME FROM Employees e LEFT JOIN EmployeeUNI eu ON e.id=eu.id;
