use ecare;
--
-- Table `options`
--
SET FOREIGN_KEY_CHECKS=0;
drop table if exists options;
SET FOREIGN_KEY_CHECKS=1;
create table options (
  id     bigint NOT NULL AUTO_INCREMENT,
  title varchar(100),
  price  int,
  activation_cost int,
  primary key (id)
  )ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
 
LOCK TABLES `options` WRITE;
insert into options values (1001, '50Mb', 50, 0);
insert into options values (1002, '100Mb', 100, 0);
insert into options values (1003, '500Mb', 450, 0);
insert into options values (1004, '1024Mb', 700, 0);
insert into options values (1005, '50SMS', 50, 20);
insert into options values (1006, '100SMS', 80, 0);
insert into options values (1007, '200SMS', 130, 0);
insert into options values (1008, 'Free Roaming', 500, 100);
insert into options values (1009, 'All World', 350, 60);
insert into options values (1010, 'All Russia', 350, 60);
insert into options values (1011, 'All Europe', 350, 60);
insert into options values (1012, '50MMS', 100, 50);
insert into options values (1013, '100MMS', 150, 50);
insert into options values (1014, 'White Nights', 150, 50);
insert into options values (1015, 'GreenGrass.ru', 150, 50);
insert into options values (1016, 'Finland', 150, 50);
insert into options values (1017, 'Season ticket', 150, 50);
insert into options values (1018, 'Full unlim', 150, 50);
insert into options values (1019, 'Internet per nights', 150, 50);
insert into options values (1020, 'Express calls', 150, 50);
insert into options values (1021, 'GPRS active', 150, 50);
insert into options values (1022, 'Internet active', 150, 50);
insert into options values (1023, 'MMS Active', 150, 50);
UNLOCK TABLES;

--
-- Table `tariffs_options`
--

-- SET FOREIGN_KEY_CHECKS=0;
-- drop table if exists tariffs_options;
-- SET FOREIGN_KEY_CHECKS=1;

-- create table tariffs_options (
  -- tariff_id  bigint NOT NULL,
  -- option_id  bigint NOT NULL,
  -- primary key (tariff_id, option_id),
  -- KEY `FK_tariffs_options` (`tariff_id`),
  -- KEY `FK_options_tariffs` (`option_id`),
  -- CONSTRAINT `FK_tariffs_options` FOREIGN KEY (`tariff_id`) REFERENCES `tariffs` (`id`)  ON DELETE CASCADE ON UPDATE RESTRICT,
  -- CONSTRAINT `FK_options_tariffs` FOREIGN KEY (`option_id`) REFERENCES `options` (`id`)  ON DELETE CASCADE ON UPDATE RESTRICT
  -- )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
-- LOCK TABLES `tariffs_options` WRITE;
-- insert into tariffs_options values (1001, 1008);
-- insert into tariffs_options values (1001, 1014);
-- UNLOCK TABLES;

--
-- Table `contracts`
--
SET FOREIGN_KEY_CHECKS=0;
drop table if exists contracts;
SET FOREIGN_KEY_CHECKS=1;
create table contracts (
  id     bigint NOT NULL AUTO_INCREMENT,
  contract_number  varchar(11),
  tariff_id bigint,
  client_id bigint,
  blocked_by_salesman bit(1),
  blocked_by_client bit(1),
  primary key (id),
  KEY `FK_contract_tariff` (`tariff_id`),
  KEY `FK_contract_client` (`client_id`),
  CONSTRAINT `FK_contract_tariff` FOREIGN KEY (`tariff_id`) REFERENCES `tariffs` (`id`)  ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `FK_contract_client` FOREIGN KEY (`client_id`) REFERENCES `users` (`id`)  ON DELETE CASCADE ON UPDATE RESTRICT
  )ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
 
LOCK TABLES `contracts` WRITE;
insert into contracts values (1001, '89118667755', 1002, 1003, b'0', b'1');
insert into contracts values (1002, '89234563322', 1003, 1004, b'0', b'0');
UNLOCK TABLES;

--
-- Table `tariffs`
--
SET FOREIGN_KEY_CHECKS=0;
drop table if exists tariffs;
SET FOREIGN_KEY_CHECKS=1;
create table tariffs (
  id     bigint NOT NULL AUTO_INCREMENT,
  price  int,
  title varchar(100),
  primary key (id)
  )ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
 
LOCK TABLES `tariffs` WRITE;
insert into tariffs values (1001, 350, 'MAXI plus');
insert into tariffs values (1002, 200, 'Zero');
insert into tariffs values (1003, 100, 'Super Telecom');
insert into tariffs values (1004, 300, 'Smart+');
insert into tariffs values (1005, 250, 'Smart');
insert into tariffs values (1006, 200, 'Smart Mini');
insert into tariffs values (1007, 400, 'Smart Top');
insert into tariffs values (1008, 400, 'All Inclusive');
insert into tariffs values (1009, 400, 'Per-second billing');
UNLOCK TABLES;


--
-- Table `users`
--
SET FOREIGN_KEY_CHECKS=0;
drop table if exists users;
SET FOREIGN_KEY_CHECKS=1;
create table users (
  id     bigint NOT NULL AUTO_INCREMENT,
  name  varchar(50),
  surname varchar(50),
  email  varchar(50),
  age int,
  primary key (id)
  )ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
 
LOCK TABLES `users` WRITE;
insert into users values (1001, 'Ivan', 'Ivanov', 'Ivan.Ivanov@mail.ru', 18);
insert into users values (1002, 'Anna', 'Urix', 'Anna.Urix@yandex.ru', 22);
insert into users values (1003, 'Petya', 'Gurevich', 'Petya.Gurevich@gmail.com', 44);
insert into users values (1004, 'Angelina', 'Pipka', 'Angela@inbox.ru', 63);
insert into users values (1005, 'Sveta', 'Yys', 'dom@mail.su', 33);
insert into users values (1006, 'Stephan', 'Lebedenko', 'stepa@km.ru', 47);
UNLOCK TABLES;
 
select * from users;