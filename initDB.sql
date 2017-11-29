drop database contrader;
create database contrader;

create table contrader.users (
U_id int(50) not null auto_increment,
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
primary key(U_id)

);

insert into contrader.users (U_id, username, password, firstname, lastname, dateofbirth, CF, businessname, vat, town, CAP, city, address, telephone, role) values (1, 'pippo', 'paperino', 'pippo', 'paperino','28/11/1970', 'PPRNPPO70RX90A', 'paperino.srl', '010203040506', 'Ariano Irpino', '83031', 'Avellino', 'Via Afflitto', '0825362548', 'User');
insert into contrader.users (U_id, username, password, firstname, lastname, dateofbirth, CF, businessname, vat, town, CAP, city, address, telephone, role) values (2,'ciccio', 'bello', 'ciccio', 'bello', '09/09/1982', 'BLLCCI82XD97O', 'bello.srl', '987965453212', 'Benevento','82100', 'Benevento', 'Viale Mellusi 9', '0824387965', 'Admin');

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
primary key(G_id)
);
insert into contrader.gomme (G_id, typevehicle, model, manufacturer, price, width, height, diameter, weight, speed, season) values (1, 'auto','Trelleborg-B50', 'Trelleborg', 321.13, 125, 125, 125, 100, '90', '4 stagioni');
insert into contrader.gomme (G_id, typevehicle, model, manufacturer, price, width, height, diameter, weight, speed, season) values (2,'moto', 'SuperG-876 ', 'Super Gomme', 213.176, 105, 105, 105, 97, '80', 'Estiva');
insert into contrader.gomme (G_id, typevehicle, model, manufacturer, price, width, height, diameter, weight, speed, season) values (3, 'auto', 'Pir-XD20 ', 'Pirelli', 300.25, 115, 115, 115, 205.31, '100', 'Invernale');

create table contrader.vehicle (
V_id int(50) not null auto_increment,
brand varchar(30),
model varchar(50),
power varchar(20),
version varchar(20),
capacity varchar(20),
primary key(V_id)
);
insert into contrader.vehicle (V_id, brand, model, power, version, capacity) values (1, 'Fiat', 'Punto', 'Evo', 'Diesel', '1.368');
insert into contrader.vehicle (V_id, brand, model, power, version, capacity) values (2, 'Opel', 'Corsa', '2007', 'Diesel', '1.200');
insert into contrader.vehicle (V_id, brand, model, power, version, capacity) values (3, 'Kia', 'Rio', '2016', 'Diesel', '1.200');




create table contrader.compatibility (
G_id int(50),
V_id int(50),
foreign key(G_id) references contrader.gomme(G_id),
foreign key(V_id) references contrader.vehicle(V_id)
);
insert into contrader.compatibility (G_id, V_id) values (1,1);
insert into contrader.compatibility (G_id, V_id) values (2,2);