# Write your MySQL query statement below
select Name
from Candidate 
where id = (
    select CandidateId
    from Vote
    group by CandidateID
    order by count(*) desc
    limit 1)
