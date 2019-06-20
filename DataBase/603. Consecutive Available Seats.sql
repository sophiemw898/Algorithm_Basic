# Write your MySQL query statement below
select distinct c1.seat_id
from cinema c1 join cinema c2
on c1.free = true and c2.free = true 
and abs(c1.seat_id - c2.seat_id) = 1
order by c1.seat_id
