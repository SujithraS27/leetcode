WITH temp AS(SELECT e.employee_id FROM Employees e JOIN Salaries s ON e.employee_id=s.employee_id)
SELECT employee_id FROM Employees WHERE employee_id NOT IN (SELECT employee_id FROM temp) UNION ALL SELECT employee_id FROM Salaries WHERE employee_id NOT IN(SELECT employee_id FROM temp) ORDER BY employee_id

