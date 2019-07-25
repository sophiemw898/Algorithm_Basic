//2nd
select round(avg(average), 2) as average_daily_percent
from (
    select action_date, count(distinct r.post_id) / count(distinct a.post_id) * 100 as average
    from Actions a left join Removals r
    on a.post_id = r.post_id
    where action = 'report' and extra = 'spam'
    group by action_date) as temp

//1st too many subquery
# Write your MySQL query statement below
select round((select avg(average) 
              from
              (select sum(remove_case) / count(post_id) * 100 as average
               from 
               (select distinct post_id as post_id, action_date, 
                case when post_id in 
                (select post_id from Removals where remove_date > action_date) then 1 else 0
                end as remove_case
                from Actions
                where action = 'report' and extra = 'spam') as temp1
               group by action_date) as temp2), 2)
as average_daily_percent


