# Write your MySQL query statement below
WITH temp AS(SELECT person_id,person_name,weight,turn,SUM(weight) OVER(order by turn) as amount FROM Queue)
SELECT person_name FROM temp WHERE amount<=1000 ORDER BY turn DESC LIMIT 1;
