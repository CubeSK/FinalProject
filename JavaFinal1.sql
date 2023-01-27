select * from javabooks;
alter table javabooks
rename column ï»¿Author to Author;
drop table javabooks;
drop table javabooklistexperiment;
insert into javabooks values ('xxx', 'yyy', 'zzz', 300, 2000, 2000,'History');
create table Books
as
select
*
from javabooks;
select * from books;