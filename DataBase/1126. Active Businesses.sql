# Write your MySQL query statement below
select business_id
from Events join (
    select event_type, avg(occurences) as average 
    from Events
    group by event_type) as temp
on Events.event_type = temp.event_type
and Events.occurences > temp.average
group by business_id
having count(distinct Events.event_type) > 1


