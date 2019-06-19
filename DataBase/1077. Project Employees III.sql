# Write your MySQL query statement below
select P.project_id, P.employee_id
from Project P join Employee E
on P.employee_id = E.employee_id
where (P.project_id, experience_years) in (
    select P.project_id, max(experience_years)
    from Project P join Employee E
    on P.employee_id = E.employee_id
    group by project_id
)
