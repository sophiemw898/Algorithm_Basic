# Write your MySQL query statement below
select ifnull (
    (select distinct salary
    from employee
    order by salary desc
    limit 1,1), null) as SecondHighestSalary
    
# select .. from .. order by .. limit a, b 
# select .. from .. order by .. limit b offset a
#跳过a 取b个

# Write your MySQL query statement below
select ifnull (
    (select distinct salary
    from employee
    order by salary desc
    limit 1 offset 1), null) as SecondHighestSalary
    
# Write your MySQL query statement below
select max(salary) as SecondHighestSalary
from Employee
where salary < (select max(salary) from Employee)
