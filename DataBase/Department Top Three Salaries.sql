# Write your MySQL query statement below

select D.name as Department, E.name as Employee, E.Salary
from Employee E join Department D on D.Id = E.DepartmentID
join Employee E2 on E.DepartmentId = E2.DepartmentId
where E.Salary <= E2.Salary
group by D.id, E.name 
having count(distinct(E2.salary)) <= 3
order by D.id, E.Salary desc

