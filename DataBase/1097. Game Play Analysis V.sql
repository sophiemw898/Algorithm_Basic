# Write your MySQL query statement below
#select event_date as install_dt, 

select a1.install_dt, count(a1.player_id) as installs, round(count(a2.event_date)/count(a1.player_id), 2) as Day1_retention
from (select player_id, min(event_date) as install_dt 
      from Activity 
      group by player_id) as a1 left join Activity a2
on a1.player_id = a2.player_id
and datediff(a2.event_date, a1.install_dt) = 1
group by a1.install_dt




