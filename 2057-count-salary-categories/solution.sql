# Write your MySQL query statement below
WITH categories AS (
  SELECT 'Low Salary' AS category
  UNION ALL
  SELECT 'Average Salary'
  UNION ALL
  SELECT 'High Salary'
),
counts AS (
  SELECT
    CASE
      WHEN income < 20000 THEN 'Low Salary'
      WHEN income BETWEEN 20000 AND 50000 THEN 'Average Salary'
      ELSE 'High Salary'
    END AS category
  FROM accounts
)
SELECT
  c.category,
  COALESCE(COUNT(ct.category), 0) AS accounts_count
FROM categories c
LEFT JOIN counts ct ON c.category = ct.category
GROUP BY c.category;

