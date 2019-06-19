# Write your MySQL query statement below
select 
    (case 
        when mod(id, 2) != 0 and id != counts then id + 1
        when mod(id, 2) != 0 and id = counts then id 
        else id - 1 
     end
) as id, student
from seat,(select count(*) as counts from seat) as t
order by id 
