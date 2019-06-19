# Write your MySQL query statement below
select product_id, product_name
from Product
where product_id not in (
    select product_id
    from Sales
    where sale_date not between '2019-01-01' and '2019-03-31'
)



# Write your MySQL query statement below
select Product.product_id, product_name
from Product join Sales
on Product.product_id = Sales.product_id
group by product_id
having sum(case when sale_date between '2019-01-01' and '2019-03-31' then 1 else 0 end) >0
and sum(case when sale_date between '2019-01-01' and '2019-03-31' then 0 else 1 end) = 0

