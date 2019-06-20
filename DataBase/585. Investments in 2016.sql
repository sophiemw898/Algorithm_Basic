# Write your MySQL query statement below
select round(sum(TIV_2016),2) as TIV_2016
from insurance
where TIV_2015 in ( select TIV_2015 
                    from insurance 
                    group by TIV_2015
                    having count(*) > 1)
and PID in (select PID
            from insurance 
            group by LAT, LON
            having count(*) = 1)
