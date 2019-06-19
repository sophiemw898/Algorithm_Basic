# Write your MySQL query statement below
select question_id as survey_log
from  (
    select  question_id, 
            sum(case when action = 'answer' then 1 else 0 end) as num_answer,
            sum(case when action = 'show' then 1 else 0 end)  as num_show
    from survey_log
    group by question_id
) as t
order by (num_answer/num_show) desc
limit 1




