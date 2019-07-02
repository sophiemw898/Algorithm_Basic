# Write your MySQL query statement below
select b.book_id, name
from Books b left join Orders o
on b.book_id = o.book_id and dispatch_date between '2018-06-23' and '2019-6-23' 
where available_from < '2019-5-23' 
group by b.book_id
having sum(ifnull(quantity,0)) < 10
