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
drop table if exists company;
create table company(
	id int primary key auto_increment,
	personal_name varchar(255) not null,
	company_name varchar(255) not null,
	address varchar(255) not null,
	phone varchar(255) not null,
	create_datetime timestamp not null default now()
);
drop table if exists consignment;
create table consignment(
	id int primary key auto_increment,
	datetime date not null,
	start_city varchar(255) not null,
	arrival_city varchar(255) not null,
	mode_of_transportation varchar(255) not null comment '运输方式',
	service_mode varchar(255) not null comment '服务方式',
	payment varchar(255) not null comment '付款方式',
	consignor_id int not null,
	consignee_id int not null,
	charging_ways varchar(255) not null comment '计费方式',
	unit_price double not null comment '单价',
	transport_price double not null comment '运费',
	take_cargo_price double not null comment '取货费',
	carry_cargo_price double not null comment '送货费',
	insurance_price double not null comment '保险费',
	pack_price double not null comment '包装费',
	load_unload_price double not null comment '装卸费',
	other_price double not null comment '其他费',
	collection_money double not null comment '代收款',
	collection_money_charge double not null comment '代收款手续费',
	return_price double not null,
	create_user_id int not null,
	create_datetime timestamp not null default now(),
	foreign key(consignor_id) references company(id),
	foreign key(consignor_id) references company(id),
	foreign key(create_user_id) references user(id)
);
drop table if exists cargo;
create table cargo(
	id int primary key auto_increment,
	consignment_id int not null,
	commodity_name varchar(255),
	pack varchar(255),
	number_of_packages int,
	weight double,
	volume double,
	statement_value double,
	create_datetime timestamp not null default now(),
	foreign key(consignment_id) references consignment(id)
);
