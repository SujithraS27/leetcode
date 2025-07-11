WITH temp AS(SELECT id,student,LAG(student) OVER(ORDER BY id) as prev,lead(student) OVER(order by id) as next FROM Seat)
(SELECT id,COALESCE(next,student) as student FROM temp WHERE id%2!=0)union all(SELECT id,COALESCE(prev,student) as student FROM temp WHERE id%2=0) ORDER BY id
