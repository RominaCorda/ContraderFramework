drop database contrader;
create database contrader;

create table contrader.users (
U_id int(50) NOT NULL auto_increment,
username varchar(50), 
password varchar(50),
firstname varchar(50),
lastname varchar(50),
dateofbirth varchar(50),
CF varchar(20),
businessname varchar(30),
vat varchar(50),
town varchar(30),
CAP varchar(10),
city varchar(30),
address varchar(50),
telephone varchar(30),
role varchar(30),
primary key(id)

);



create table contrader.gomme (
G_id int(50) not null auto_increment,
typevehicle varchar(30),
model varchar(50), 
manufacturer varchar(50), 
price float,
width float,
height float,
diameter float,
weight float,
speed varchar(3),
season varchar(20),
primary key(id)
);

create table contrader.vehicle (
V_id int(50) not null auto_increment,
brand varchar(30),
model varchar(50),
power varchar(20),
version varchar(20),
capacity varchar(20),
primary key(id)
);


create table contrader.compatibility (
G_id int(50),
V_id int(50),
foreign key(G_id) references contrader.gomme(G_id),
foreign key(V_id) references contrader.vehicle(V_id)
);



insert into contrader.gomme (model, manufacturer, price) values ('Trelleborg-B50', 'Trelleborg', 321.13);
insert into contrader.gomme (model, manufacturer, price) values ('SuperG-876 ', 'Super Gomme', 213.176);
insert into contrader.gomme (model, manufacturer, price) values ('Estivo ', 'Pirelli', 300.25);

insert into contrader.users (username, password) values ('pippo', 'paperino');
insert into contrader.users (username, password) values ('ciccio', 'bello');