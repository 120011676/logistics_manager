drop table if exists user;
create table user(
	id int primary key auto_increment,
	username varchar(255) not null unique,
	password varchar(255) not null,
	name varchar(255) not null,
	position boolean not null default false,
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
	order_number varchar(255) not null unique comment '订单号',
	datetime date not null comment '日期',
	start_city varchar(255) not null comment '发站',
	arrival_city varchar(255) not null comment '到站',
	mode_of_transportation varchar(255) not null comment '运输方式',
	service_mode varchar(255) not null comment '服务方式',
	payment varchar(255) not null comment '付款方式',
	shipper varchar(255) not null comment '托运人',
	shipper_unit varchar(255) not null comment '托运单位',
	shipper_address varchar(255) not null comment '托运人地址',
	shipper_phone varchar(255) not null comment '托运人电话',
	consignee varchar(255) comment '收货人',
	consignee_unit varchar(255) comment '收货单位',
	consignee_address varchar(255) comment '收货地址',
	consignee_phone varchar(255) comment '收货电话',
	commodity_name_one varchar(255) comment '品名1',
	commodity_name_two varchar(255) comment '品名2',
	commodity_name_three varchar(255) comment '品名3',
	commodity_name_four varchar(255) comment '品名4',
	commodity_name_five varchar(255) comment '品名5',
	commodity_package_one varchar(255) comment '包装1',
	commodity_package_two varchar(255) comment '包装2',
	commodity_package_three varchar(255) comment '包装3',
	commodity_package_four varchar(255) comment '包装4',
	commodity_package_five varchar(255) comment '包装5',
	commodity_package_number_one int comment '件数1',
	commodity_package_number_two int comment '件数2',
	commodity_package_number_three int comment '件数3',
	commodity_package_number_four int comment '件数4',
	commodity_package_number_five int comment '件数5',
	commodity_weight_one double comment '重量1',
	commodity_weight_two double comment '重量2',
	commodity_weight_three double comment '重量3',
	commodity_weight_four double comment '重量4',
	commodity_weight_five double comment '重量5',
	commodity_volume_one double comment '体积1',
	commodity_volume_two double comment '体积2',
	commodity_volume_three double comment '体积3',
	commodity_volume_four double comment '体积4',
	commodity_volume_five double comment '体积5',
	commodity_worth_one double comment '声明价值1',
	commodity_worth_two double comment '声明价值2',
	commodity_worth_three double comment '声明价值3',
	commodity_worth_four double comment '声明价值4',
	commodity_worth_five double comment '声明价值5',
	charging_ways varchar(255) not null comment '计费方式',
	unit_price double not null comment '单价',
	transport_price double not null comment '运费',
	take_cargo_price double comment '取货费',
	carry_cargo_price double comment '送货费',
	insurance_price double comment '保险费',
	pack_price double comment '包装费',
	load_unload_price double comment '装卸费',
	other_price double comment '其他费',
	collection_money double comment '代收款',
	collection_money_charge double comment '代收款手续费',
	return_price double comment '返单手续费',
	create_user_id int not null,
	create_datetime timestamp not null default now(),
	sign_shipper varchar(255) comment '托运人（签字）姓名',
	sign_carrier varchar(255) comment '承运人（签字）姓名',
	sign_consignee varchar(255) comment '收货人（签字）姓名',
	sign_datetime date comment '收获日期',
	status varchar(255) not null comment '状态',
	enable boolean not null default true comment 'ture:正常，false：删除',
	foreign key(create_user_id) references user(id)
);

update consignment set charging_ways = '重量和' where charging_ways = '1';
update consignment set charging_ways = '体积和' where charging_ways = '2';