# Write your MySQL query statement below
select D.Name as Department, E.Name as Employee, Salary
from Department as D join Employee as E
on E.DepartmentId = D.Id
where (E.DepartmentId, E.Salary) in (
    select DepartmentId, max(Salary)
    from Employee
    group by DepartmentId
)
