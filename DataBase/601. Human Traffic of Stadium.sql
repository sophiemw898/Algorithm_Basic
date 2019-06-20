# Write your MySQL query statement below
select distinct t1.*
from stadium t1, stadium t2, stadium t3
where t1.people >= 100 and t2.people >= 100 and t3.people >= 100
and (
	  (t1.id - t2.id = 1 and t1.id - t3.id = 2 and t2.id - t3.id =1)  -- t1, t2, t3
    or
    (t2.id - t1.id = 1 and t2.id - t3.id = 2 and t1.id - t3.id =1) -- t2, t1, t3
    or
    (t3.id - t2.id = 1 and t2.id - t1.id =1 and t3.id - t1.id = 2) -- t3, t2, t1
)
order by t1.id

# Write your MySQL query statement below
select distinct *
from stadium
where people >= 100 
and (
((id -1 in (select id from stadium where people > 99 ))
and
(id -2 in (select id from stadium where people > 99 )))

or 
((id -1 in (select id from stadium where people > 99 ))
and 
(id +1 in (select id from stadium where people > 99 )))
  
or 
((id+1 in (select id from stadium where people > 99 ))
and 
(id+2 in (select id from stadium where people > 99 )))
)
order by id
