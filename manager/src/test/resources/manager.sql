drop table if exists user;
create table user(
	id int primary key auto_increment,
	username varchar(255) not null unique,
	password varchar(255) not null,
	name varchar(255) not null,
	enable boolean not null default true,
	create_datetime timestamp not null default now()
);
insert user(username,password,name) value('admin','admin','超级用户');