WITH temp1 AS(SELECT student_id,subject,score,exam_date,DENSE_RANK() OVER(PARTITION BY student_id,subject ORDER BY exam_date) AS rn1 FROM Scores),temp2 AS(SELECT student_id,subject,score,exam_date,DENSE_RANK() OVER(PARTITION BY student_id,subject ORDER BY exam_date DESC) AS rn2 FROM Scores)
SELECT t1.student_id,t1.subject,t1.score AS first_score,t2.score AS latest_score FROM temp1 t1 JOIN temp2 t2 ON t1.student_id=t2.student_id AND t1.subject=t2.subject WHERE t1.rn1=1 AND t2.rn2=1 AND t1.score<t2.score

