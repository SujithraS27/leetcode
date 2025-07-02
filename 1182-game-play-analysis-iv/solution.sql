# Write your MySQL query statement below
WITH temp AS(SELECT player_id,device_id,event_date,games_played,ROW_NUMBER() OVER (PARTITION BY player_id ORDER BY event_date) AS rn,LAG(event_date) OVER(PARTITION BY player_id ORDER BY event_date) AS prev_date FROM Activity)
SELECT ROUND(SUM(CASE WHEN rn=2 AND DATEDIFF(event_date, prev_date) = 1 THEN 1 ELSE 0 END)/COUNT(DISTINCT player_id),2) AS fraction FROM temp
