# Write your MySQL query statement below
select dept_name, count(distinct student_id) as student_number
from department left join student
on department.dept_id = student.dept_id
group by department.dept_id
order by student_number desc, dept_name
