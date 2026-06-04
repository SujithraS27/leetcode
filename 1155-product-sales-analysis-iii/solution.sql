# Write your MySQL query statement below
WITH TEMP AS(SELECT sale_id,product_id,year,quantity,price,RANK() OVER(PARTITION BY product_id ORDER BY year) AS rnk FROM Sales)
SELECT product_id,year AS first_year,quantity,price FROM TEMP WHERE rnk=1;
