WITH temp AS(SELECT u.name,SUM(t.amount) AS balance FROM Users u JOIN Transactions t ON u.account=t.account GROUP BY t.account)
SELECT * FROM temp WHERE balance>10000;
