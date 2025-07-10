# Write your MySQL query statement below
WITH temp AS(SELECT u.name,u.user_id,COUNT(*) AS ratingcount FROM MovieRating mr JOIN Users u ON u.user_id=mr.user_id GROUP BY mr.user_id,u.name)
(SELECT name AS results FROM temp WHERE ratingcount=(SELECT MAX(ratingcount) FROM temp) ORDER BY name LIMIT 1) union all 
(SELECT title AS results
FROM Movies m 
JOIN MovieRating mr ON m.movie_id = mr.movie_id 
WHERE mr.created_at BETWEEN '2020-02-01' AND '2020-02-29'
GROUP BY m.movie_id, m.title
ORDER BY AVG(mr.rating) DESC, m.title
LIMIT 1);
