SELECT America, Asia, Europe
FROM
(select @as:=0, @am:=0, @eu:=0) as t,
(select @as:= @as +1 as asid, name as Asia
from student
where continent = 'Asia'
order by Asia) as t1
RIGHT JOIN
(select @am:= @am +1 as amid, name as America
from student
where continent = 'America'
order by America) as t2
ON asid = amid
LEFT JOIN
(select @eu:= @eu +1 as euid, name as Europe
from student
where continent = 'Europe'
order by Europe) as t3
ON amid = euid
