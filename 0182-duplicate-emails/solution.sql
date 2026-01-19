# Write your MySQL query statement below
SELECT email as Email FROM(SELECT email,count(email) as e FROM Person GROUP BY email HAVING e>1) as t
