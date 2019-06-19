# Write your MySQL query statement below
select distinct(buyer_id) 
from Sales
where buyer_id in (
    select buyer_id
    from Product join Sales
    on Product.product_id = Sales.product_id
    where product_name = 'S8'
)
and buyer_id not in (
    select buyer_id
    from Product join Sales
    on Product.product_id = Sales.product_id
    where product_name = 'iPhone'
)


# Write your MySQL query statement below
select distinct(buyer_id) 
from Product join Sales
on Product.product_id = Sales.product_id
group by buyer_id
having sum(case when product_name = 'S8' then 1 else 0 end) > 0
and sum(case when product_name = 'iPhone' then 1 else 0 end) = 0

