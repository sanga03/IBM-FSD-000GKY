create table instructor_detail(id int primary key auto_increment,youtube_channel varchar(55),hobby varchar(55));
drop table instructor_detail;
use javadatabase;


create table instructor(id int primary key auto_increment,name varchar(27),email varchar(20)
,instructor_detail_id int
,key `FK_DETAIL_idx` (`instructor_detail_id`),
constraint `FK_DETAIL` foreign key (`instructor_detail_id`) references instructor_detail(id) on 
delete no action on update no action);

drop table cd;

create table cd(id int primary key auto_increment,title varchar(27),artist varchar(30),rdate date,specialEdition varchar(30),featuredEdition varchar(50),ctype varchar(30));

select * from cd;