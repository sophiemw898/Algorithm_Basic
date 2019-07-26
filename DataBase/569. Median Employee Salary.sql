# Write your MySQL query statement below
select 
  Employee.Id, 
  Employee.Company, 
  Employee.Salary
from Employee join Employee alias
on Employee.Company = alias.Company
group by Employee.Company , Employee.Salary
having sum(case when Employee.Salary = alias.Salary THEN 1 else 0 end) 
            >= abs( #SUM(SIGN(Employee.Salary - alias.Salary)))
                (select count(*)
                 from employee e1 
                 where Employee.Company = e1.Company and Employee.Salary <= e1.Salary) - 
                (select count(*) 
                 from employee e1 
                 where Employee.Company = e1.Company and Employee.Salary >= e1.Salary)
                )
order by Employee.id
                         
#1应为num出现的个数
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
