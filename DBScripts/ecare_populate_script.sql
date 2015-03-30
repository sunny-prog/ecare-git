use ecare;
 

--
-- Table `users`
--
drop table if exists users;
create table users (
  id     bigint NOT NULL AUTO_INCREMENT,
  name  varchar(50),
  surname varchar(50),
  primary key (id)
  )ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
 
LOCK TABLES `users` WRITE;
insert into users values (1001, 'Ivan', 'Ivanov');
insert into users values (1002, 'Anna', 'Urix');
insert into users values (1003, 'Petya', 'Petrov');
insert into users values (1004, 'Angelina', 'Shalcman');
insert into users values (1005, 'Sveta', 'Kirova');
insert into users values (1006, 'Stephan', 'Uihkman');
UNLOCK TABLES;

--
-- Table `tariffs`
--
drop table if exists tariffs;
create table tariffs (
  id     bigint NOT NULL AUTO_INCREMENT,
  price  int,
  title varchar(100),
  primary key (id)
  )ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
 
LOCK TABLES `tariffs` WRITE;
insert into tariffs values (1001, 350, 'MAXI plus');
insert into tariffs values (1002, 200, 'Zero');
UNLOCK TABLES;

--
-- Table `options`
--
drop table if exists options;
create table options (
  id     bigint NOT NULL AUTO_INCREMENT,
  title varchar(100),
  price  int,
  activation_cost int,
  primary key (id)
  )ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
 
LOCK TABLES `options` WRITE;
insert into options values (1001, '50Mb', 50, 0);
insert into options values (1002, '100Mb', 100, 0);
UNLOCK TABLES;
 
select * from users;