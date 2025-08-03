WITH temp AS(SELECT employee_id,DATE_SUB(meeting_date,INTERVAL WEEKDAY(meeting_date) DAY) AS startweek,SUM(duration_hours) AS hours FROM meetings GROUP BY employee_id,DATE_SUB(meeting_date,INTERVAL WEEKDAY(meeting_date) DAY)),calc AS(SELECT *,COUNT(*) AS meeting_heavy_weeks FROM temp WHERE hours>20 GROUP BY employee_id HAVING COUNT(*)>=2)
SELECT e.employee_id,e.employee_name,e.department,m.meeting_heavy_weeks FROM employees e JOIN calc m ON e.employee_id=m.employee_id ORDER BY m.meeting_heavy_weeks DESC,e.employee_name

