# Write your MySQL query statement below
SELECT id AS Id FROM (SELECT id,temperature,recordDate,LAG(temperature) OVER(ORDER BY recordDate) as prev_temp,LAG(recordDate) OVER (ORDER BY recordDate) AS prev_date FROM Weather) AS wea  WHERE temperature>prev_temp AND DATEDIFF(recordDate,prev_date)=1;
