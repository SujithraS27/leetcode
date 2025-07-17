WITH temp AS (
  SELECT s.product_id,p.product_name,p.category,s.sale_date,s.quantity,s.price,
    CASE 
      WHEN MONTH(s.sale_date) IN (12, 1, 2) THEN 'Winter'
      WHEN MONTH(s.sale_date) IN (3, 4, 5) THEN 'Spring'
      WHEN MONTH(s.sale_date) IN (6, 7, 8) THEN 'Summer'
      WHEN MONTH(s.sale_date) IN (9, 10, 11) THEN 'Fall'
    END AS season
  FROM sales s JOIN products p ON s.product_id=p.product_id
),stats AS(SELECT season,category,SUM(quantity) AS total_quantity,SUM(price*quantity) AS total_revenue FROM temp GROUP BY season,category),
te AS(SELECT *,RANK() OVER(partition by season ORDER BY total_quantity DESC,total_revenue DESC) AS rn FROM stats)
SELECT
  season,
  category,total_quantity,total_revenue
FROM te
WHERE rn = 1
ORDER BY FIELD(season,'Fall','Spring','Summer','Winter');
