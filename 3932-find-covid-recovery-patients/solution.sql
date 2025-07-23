WITH temp AS(SELECT p.patient_id,p.patient_name,p.age,c.test_date,c.result FROM patients p JOIN covid_tests c ON p.patient_id=c.patient_id),first_positive AS(SELECT patient_id,result,MIN(test_date) AS first_pos_date FROM covid_tests WHERE result="Positive" GROUP BY patient_id),neg AS(SELECT f.patient_id,
        MIN(t.test_date) AS first_neg_date
    FROM first_positive f
    JOIN temp t 
        ON f.patient_id = t.patient_id
        AND t.result = 'Negative'
        AND t.test_date > f.first_pos_date
    GROUP BY f.patient_id)
    SELECT 
    p.patient_id,
    p.patient_name,
    p.age,
    DATEDIFF(n.first_neg_date, f.first_pos_date) AS recovery_time
FROM first_positive f
JOIN neg n ON f.patient_id = n.patient_id
JOIN patients p ON p.patient_id = f.patient_id
ORDER BY recovery_time ASC, p.patient_name ASC;


