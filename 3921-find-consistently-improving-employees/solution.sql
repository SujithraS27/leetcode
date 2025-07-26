WITH ranked_reviews AS (
    SELECT 
        pr.employee_id,
        e.name,
        pr.review_date,
        pr.rating,
        ROW_NUMBER() OVER (PARTITION BY pr.employee_id ORDER BY pr.review_date DESC) AS rn
    FROM performance_reviews pr
    JOIN employees e ON pr.employee_id = e.employee_id
),
last_three AS (
    SELECT 
        employee_id,
        name,
        MAX(CASE WHEN rn = 1 THEN rating END) AS rating1,  -- latest
        MAX(CASE WHEN rn = 2 THEN rating END) AS rating2,
        MAX(CASE WHEN rn = 3 THEN rating END) AS rating3
    FROM ranked_reviews
    WHERE rn <= 3
    GROUP BY employee_id, name
),
filtered AS (
    SELECT 
        employee_id,
        name,
        rating1 - rating3 AS improvement_score,
        rating1, rating2, rating3
    FROM last_three
    WHERE rating3 IS NOT NULL
      AND rating3 < rating2 
      AND rating2 < rating1  -- strictly increasing
)
SELECT 
    employee_id,
    name,
    improvement_score
FROM filtered
ORDER BY improvement_score DESC, name ASC;

