create table instructor_detail(id int primary key auto_increment,youtube_channel varchar(55),hobby varchar(55));
drop table instructor_detail;
use javadatabase;
show tables;
select * from employee;
desc instructor;
desc instructor_detail;
drop table student;
create table student(id int primary key auto_increment,name varchar(50),lname varchar(50),country varchar(30),lang varchar(10));
select * from instructor;
select * from instructor_detail;
create table criccoach(id int primary key auto_increment,teamname varchar(50),loc varchar(50));
create table instructor(id int primary key auto_increment,name varchar(27),email varchar(20)
,instructor_detail_id int
,key `FK_DETAIL_idx` (`instructor_detail_id`),
constraint `FK_DETAIL` foreign key (`instructor_detail_id`) references instructor_detail(id) on 
delete no action on update no action);
select * from student;
select * from student where name like '%sa%' or lname like "%m%";


drop table cd;

create table cd(id int primary key auto_increment,title varchar(27),artist varchar(30),rdate date,specialEdition varchar(30),featuredEdition varchar(50),ctype varchar(30));
select * from criccoach;

select * from cd;
use javadatabase;
create table crm(id int primary key auto_increment,fname varchar(27),lname varchar(30),email varchar(40));
desc crm;
select * from crm;
