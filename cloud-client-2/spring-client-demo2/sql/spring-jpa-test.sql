create database spring_test_00;

use spring_test_00;

create table app_user_00(
id bigint not null primary key auto_increment,
name varchar(20)
)engine=InnoDB,charset=utf8mb4;

create table app_user_01(
id bigint not null primary key auto_increment,
name varchar(20)
)engine=InnoDB,charset=utf8mb4;

create table err_logs(
id bigint not null primary key auto_increment,
app_name varchar(20),
target_app_name varchar(20),
service_path varchar(100),
error_msg text,
gmt_created datetime,
gmt_updated datetime
)engine=InnoDB,charset=utf8mb4;
