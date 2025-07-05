# Write your MySQL query statement below
WITH temp AS(SELECT sale_id,product_id,year,quantity,price,RANK() OVER(PARTITION BY product_id ORDER BY year) AS rn FROM Sales)
SELECT product_id,year AS first_year,quantity,price FROM temp WHERE rn=1;
