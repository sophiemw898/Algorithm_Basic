# Write your MySQL query statement below
select s.Score, count(distinct r.Score) as Rank
from Scores s join Scores r
on s.Score <= r.Score
group by s.Id
order by s.Score desc
