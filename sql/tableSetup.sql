use jdbctest;

DROP TABLE IF EXISTS `bottoms`;
DROP TABLE IF EXISTS `tops`;
DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `username` varchar(20) NOT NULL,  
  `password` varchar(30) NOT NULL,
  `balance` int NOT NULL,
  PRIMARY KEY (`username`)
) ;

CREATE TABLE `tops` (
  `tFlavour` varchar(30) NOT NULL,
  `tPrice` int NOT NULL,
  PRIMARY KEY (`tFlavour`)
) ;

CREATE TABLE `bottoms` (
  `bFlavour` varchar(30) NOT NULL,
  `bPrice` int NOT NULL,
  PRIMARY KEY (`bFlavour`)
) ;


insert into login(username,password,balance)
values ('Arne','Arnested',1000), ('Berit','BeRittersport',1500),('Conrad','ConAir',15);

insert into bottoms(bFlavour,bPrice)
values ('Chocolate',5),
('Vanilla',5), 
('Nutmeg',5), 
('Pistachio',6), 
('Almond',7);

insert into tops(tFlavour,tPrice)
values ('Chocolate',5),
('Blueberry',5), 
('Raspberry',5), 
('Crispy',6), 
('Strawberry',6), 
('Rum/raisin',7), 
('Orange',8), 
('Lemon',8), 
('Blue cheese',9);
