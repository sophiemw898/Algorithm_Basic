select id, count(id) as num
from (select requester_id as id from request_accepted 
union all
select accepter_id as id from request_accepted) as temp
group by id
order by num desc
limit 1

