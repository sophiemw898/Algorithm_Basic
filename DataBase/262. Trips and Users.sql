# Write your MySQL query statement below
select Request_at as Day, 
round((sum(case when Status = 'completed' then 0 else 1 end)/count(*)),2) as 'Cancellation Rate'
from Trips
where Client_id in (select Users_id from Users where Banned = "No" and Role = 'client')
and Driver_id in (select Users_id from Users where Banned = "No" and Role = 'driver')
and request_at between '2013-10-01' and '2013-10-03'
group by Request_at
