create database if not exists `localshop`;

use localshop;

create table if not exists user (
id int not null auto_increment,
email varchar(50) default null,
password varchar(50) default null,
mobile_no varchar(10) default null,
primary key (`id`)

) Engine=InnoDB Auto_increment=1 default charset=latin1 ;