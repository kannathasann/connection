
create table user(
id  int auto_increment,
name varchar(256),
about varchar(256),
idea varchar(256),
age int,
location varchar(256),
experience varchar(256),
interested varchar(256),
education varchar(256),
primary key(id)
);


insert into user( name, about, idea, age, location, experience, interested, education)
values('kanna', 'no prior startup experience', 'exploring new ideas', 24, 'Bangalore', 'Software Engineer in Google', 'E-Commerce', 'Anna University, Chennai');
