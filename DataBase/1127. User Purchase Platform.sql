# Write your MySQL query statement below
# Write your MySQL query statement below
select 
    frame.spend_date, 
    frame.platform,
    ifnull(sum(amount), 0) as total_amount,
    count(temp.user_id) as total_users 
    
from
(
    select distinct spend_date, 'desktop' as platform from Spending
    UNION ALL
    select distinct spend_date, 'mobile' as platform from Spending
    UNION ALL
    select distinct spend_date, 'both' as platform from Spending 
    #order by spend_date
) frame
left join 
(
    select 
        spend_date,
        user_id,
        amount,
        case when number = 2 then 'both'
             when number = 1 and platform = 'mobile' then 'mobile'
             else 'desktop' 
        end as platform
    from 
        (select 
            user_id, 
            spend_date, 
            platform, 
            sum(amount) as amount, 
            sum(case when platform = 'mobile' then 1
                     when platform = 'desktop' then 1 
                     else 0
                end) as number
         from Spending 
         group by spend_date, user_id) num
) temp
on frame.spend_date = temp.spend_date 
and frame.platform = temp.platform
group by spend_date, platform


