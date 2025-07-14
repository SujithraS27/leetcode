WITH price_cte AS (
  SELECT
    product_id,
    new_price,
    ROW_NUMBER() OVER (
      PARTITION BY product_id
      ORDER BY change_date DESC
    ) AS rn
  FROM Products
  WHERE change_date <= '2019-08-16'
)

SELECT
  p.product_id,
  COALESCE(pc.new_price, 10) AS price
FROM
  (SELECT DISTINCT product_id FROM Products) p
  LEFT JOIN price_cte pc
    ON p.product_id = pc.product_id AND pc.rn = 1;


