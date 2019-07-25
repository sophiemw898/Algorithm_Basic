# Write your MySQL query statement below
#select book_id, name

select Books.book_id, name
from Books left join Orders 
on Books.book_id = Orders.book_id
and dispatch_date between '2018-06-23' and '2019-06-23'

where available_from < '2019-05-23'
#and dispatch_date between '2018-06-23' and '2019-06-23'

group by book_id
having sum(quantity) < 10 or sum(quantity) is null

#having之后的表示对group之后的条件 多位sum count avg等
#group之前限制的条件在group by之前用where显示

#inner join中on 与 where没区别
#left join中 on之用来限制join右边的table 
#where则是限制两边的，只在join之后的table中选择 
#所以这题里面dispatch_date的限制得在on之后，不然left join特性想要保留的左边表的id就不见了

