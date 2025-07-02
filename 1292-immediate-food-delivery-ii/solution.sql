# Write your MySQL query statement below
WITH temp_table AS(SELECT delivery_id,customer_id,order_date,customer_pref_delivery_date,ROW_NUMBER() OVER(PARTITION BY customer_id ORDER BY order_date) AS r FROM Delivery)
SELECT ROUND(SUM(CASE WHEN order_date=customer_pref_delivery_date THEN 1 ELSE 0 END)*100.0/COUNT(*),2) AS immediate_percentage FROM temp_table WHERE r=1;
