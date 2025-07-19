WITH TEMP AS(SELECT u.id,u.name,r.distance FROM Users u LEFT JOIN Rides r ON u.id=r.user_id)
SELECT name,COALESCE(SUM(distance),0) AS travelled_distance FROM TEMP GROUP BY id ORDER BY travelled_distance DESC,name
