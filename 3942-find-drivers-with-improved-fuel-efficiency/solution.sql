WITH temp AS (
    SELECT 
        d.driver_id,
        d.driver_name,
        AVG(CASE 
              WHEN MONTH(t.trip_date) <= 6 
              THEN t.distance_km / t.fuel_consumed 
              ELSE NULL 
            END) AS first_half_avg,
        AVG(CASE 
              WHEN MONTH(t.trip_date) > 6 
              THEN t.distance_km / t.fuel_consumed 
              ELSE NULL 
            END) AS second_half_avg
    FROM drivers d
    JOIN trips t ON d.driver_id = t.driver_id
    GROUP BY d.driver_id, d.driver_name
    HAVING 
        COUNT(CASE WHEN MONTH(t.trip_date) <= 6 THEN 1 END) > 0
        AND
        COUNT(CASE WHEN MONTH(t.trip_date) > 6 THEN 1 END) > 0
),t AS(SELECT 
    driver_id,
    driver_name,
    ROUND(first_half_avg, 2) AS first_half_avg,
    ROUND(second_half_avg, 2) AS second_half_avg,
    ROUND(second_half_avg - first_half_avg, 2) AS efficiency_improvement
FROM temp 
ORDER BY efficiency_improvement DESC,driver_name)
SELECT * FROM t WHERE efficiency_improvement>0

