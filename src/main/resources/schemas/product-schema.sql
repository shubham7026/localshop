create database if not exists `localshop`;

use localshop;

create table if not exists product (
id int not null ,
price DECIMAL(8,2) default null,
product_origin varchar(50) default null,
primary key (`id`)

) ;