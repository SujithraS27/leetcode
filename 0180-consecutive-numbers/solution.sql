# Write your MySQL query statement below
SELECT DISTINCT num AS consecutiveNums 
FROM (
    SELECT 
        num,
        LEAD(num, 1) OVER (ORDER BY id) AS num1,
        LEAD(num, 2) OVER (ORDER BY id) AS num2
    FROM Logs
) AS Logs2
WHERE num = num1 AND num = num2;
