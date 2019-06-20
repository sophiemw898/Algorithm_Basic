# Write your MySQL query statement below
select e1.Id, e1.Month, sum(e2.Salary) as Salary
from Employee e1 join Employee e2
on e1.Id = e2.Id and e1.Month >= e2.Month and e1.Month - e2.Month <= 2
where e1.Month < (select max(Month) from Employee where Id = e1.Id)
group by e1.id, e1.Month
order by e1.id, e1.Month desc

