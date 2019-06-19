# Write your MySQL query statement below
select round(p.count / q.count,2) as fraction from
(select count(distinct a1.player_id) as count from 
    (select player_id, min(event_date) as event_date
    from Activity
    group by player_id) as a1 join Activity a2
    on a1.player_id = a2.player_id 
    where datediff(a2.event_date, a1.event_date) = 1) as p,
(select count(distinct player_id) as count from Activity) as q


# Write your MySQL query statement below
select round(
    (select count(distinct a1.player_id) 
     from (select player_id, min(event_date) as event_date
           from Activity
           group by player_id) as a1 join Activity a2
     on a1.player_id = a2.player_id 
     where datediff(a2.event_date, a1.event_date) = 1) 
    / (select count(distinct player_id) as count from Activity),2)
as fraction


