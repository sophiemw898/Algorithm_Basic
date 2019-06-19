# Write your MySQL query statement below
select max(num) as num 
from (
    select num
    from my_numbers
    group by num
    having count(num) = 1
) as temp


select ifnull (
    (select num
    from my_numbers
    group by num
    having count(num) = 1
    order by num desc
    limit 1), null
) as num
