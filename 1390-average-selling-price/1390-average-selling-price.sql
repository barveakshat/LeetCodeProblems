# Write your MySQL query statement below
select p.product_id, ifnull(round(sum(price * units)/sum(units),2),0) as average_price
from Prices p 
left join UnitsSold u
on p.product_id = u.product_id
    and u.purchase_date BETWEEN start_date AND end_date
group by product_id