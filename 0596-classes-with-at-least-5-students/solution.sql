# Write your MySQL query statement below
WITH CTE AS(SELECT COUNT(*) AS cnt,class FROM Courses GROUP BY class)
SELECT class FROM CTE WHERE cnt>=5;
