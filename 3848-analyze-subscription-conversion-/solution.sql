WITH temp AS (
    SELECT f.user_id
    FROM (
        SELECT user_id, MIN(activity_date) AS free_trial_date
        FROM UserActivity
        WHERE activity_type = 'free_trial'
        GROUP BY user_id
    ) f
    JOIN (
        SELECT user_id, MIN(activity_date) AS paid_date
        FROM UserActivity
        WHERE activity_type = 'paid'
        GROUP BY user_id
    ) p ON f.user_id = p.user_id
    WHERE f.free_trial_date < p.paid_date
)

SELECT 
    user_id,
    ROUND(AVG(CASE WHEN activity_type = 'free_trial' THEN activity_duration END), 2) AS trial_avg_duration,
    ROUND(AVG(CASE WHEN activity_type = 'paid' THEN activity_duration END), 2) AS paid_avg_duration
FROM UserActivity
WHERE user_id IN (SELECT user_id FROM temp)
  AND activity_type IN ('free_trial', 'paid')
GROUP BY user_id;



