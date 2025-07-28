SELECT  Request_at AS Day,
        ROUND(SUM(CASE 
                WHEN Status IN ('cancelled_by_driver', 'cancelled_by_client') THEN 1 
                ELSE 0 
              END) * 1.0 / COUNT(*), 2) AS "Cancellation Rate"
FROM Trips t
JOIN Users c ON t.Client_Id = c.Users_Id AND c.Banned = 'No' AND c.Role = 'client'
JOIN Users d ON t.Driver_Id = d.Users_Id AND d.Banned = 'No' AND d.Role = 'driver'
WHERE Request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY Request_at;

