create database if not exists colorsNew;
use colorsNew;
drop table if exists colorsNew;

create table colorsNew (
hexId varchar(7) not null,
colorName varchar(50) not null, 
primary key (hexId)
);