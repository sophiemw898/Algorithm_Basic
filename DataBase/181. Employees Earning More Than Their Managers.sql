# Write your MySQL query statement below
select E.name as Employee
from Employee as E join Employee as M
on E.ManagerId = M.Id
where E.Salary > M.Salary
