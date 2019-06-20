# Write your MySQL query statement below
select * 
from Employee e
where 1 >= abs((select count(*) 
                from employee e1 
                where e.Company = e1.Company
                and e.Salary < e1.Salary) - 
               (select count(*) 
                from employee e1 
                where e.Company = e1.Company
                and e.Salary > e1.Salary))
group by Company, Salary
