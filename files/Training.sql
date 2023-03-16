-- ------------------------------------------------------------------------------
-- - Construction de la base de données                                     ---
-- ------------------------------------------------------------------------------
DROP DATABASE IF EXISTS Training;
CREATE DATABASE Training;
USE Training;

-- -----------------------------------------------------------------------------
-- - Construction de la table des formations                               ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_Trainings (
	IdTraining			int(4)			PRIMARY KEY AUTO_INCREMENT,
	trainingName			varchar(100)	NOT NULL,
	description			varchar(100)	NOT NULL,
	durationTraining		int (5)		NOT NULL,
	price 				float(5)	NOT NULL,
	presentialorremote              varchar(20)	NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Trainings (trainingName, description, durationTraining, price, presentialorremote) VALUES ('Java' , 'Java 8 : Poo et execption', 8, 800 ,'presential' );
INSERT INTO T_Trainings (trainingName, description, durationTraining, price, presentialorremote) VALUES ('Angular' , 'Angular 14 : Observables et bdd', 5, 1800.5,'remote' );
INSERT INTO T_Trainings (trainingName, description, durationTraining, price, presentialorremote) VALUES ('JavaJEE' , 'Java JEE : Servlet et JPA', 3, 500,'presential' );
INSERT INTO T_Trainings (trainingName, description, durationTraining, price, presentialorremote) VALUES ('HTML/CSS' , 'HTML5 : Introduction', 4, 600.45,'remote' );
INSERT INTO T_Trainings (trainingName, description, durationTraining, price, presentialorremote) VALUES ('C++' , 'C++ : Poo', 4, 655,'remote' );
INSERT INTO T_Trainings (trainingName, description, durationTraining, price, presentialorremote) VALUES ('Php' , 'CMS : Prestashop', 3, 555,'presential' );
INSERT INTO T_Trainings (trainingName, description, durationTraining, price, presentialorremote) VALUES ('Pack Office' , 'Word,Excel', 4, 1555.45,'remote' );
INSERT INTO T_Trainings (trainingName, description, durationTraining, price, presentialorremote) VALUES ('Python' , 'Data Scientist', 2, 955.45,'remote' );

SELECT * FROM T_Trainings;


-- -----------------------------------------------------------------------------
-- - Construction de la table des clients	                                 ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Customers (
	IdCustomer				int(4)		PRIMARY KEY AUTO_INCREMENT,
	name					varchar(30)	NOT NULL,
	firstName				varchar(30)	NOT NULL,
	email 					varchar(30)	NOT NULL unique,
	phone 					varchar(20)	NOT NULL,
	IdUser					int(4)		PRIMARY KEY AUTO_INCREMENT
	) ENGINE = InnoDB;

INSERT INTO T_Customers (name, firstName, email, phone) VALUES ('Macron' , 'Manu', 'macromanu@gmail.com','0121457841');
INSERT INTO T_Customers (name, firstName, email, phone) VALUES ('Pastor' , 'Guillaume', 'guiupast31@free.fr','1454874589');
INSERT INTO T_Customers (name, firstName, email, phone) VALUES ('Sarkozy' , 'Nico', 'sarkonicofree.fr','2145871258');
INSERT INTO T_Customers (name, firstName, email, phone) VALUES ('Biden' , 'Joe', 'biden@joe.com','0645871254');
INSERT INTO T_Customers (name, firstName, email, phone) VALUES ('Léponge' , 'Bob', 'leponge@bob.yahoo','0789654785');

ALTER TABLE t_Customers ADD COLUMN IdUser INT(4);
ALTER TABLE T_Customers ADD FOREIGN KEY(IdUser) REFERENCES T_Customers(IdUser);


SELECT * FROM T_Customers;

-- -----------------------------------------------------------------------------
-- - Construction de la table des catégories d'utilisateurs
-- -----------------------------------------------------------------------------


CREATE TABLE T_Users (
	IdUser				int(4)		PRIMARY KEY AUTO_INCREMENT,
	Login				varchar(20)	NOT NULL UNIQUE,
	Password			varchar(20)	NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 1, 'Macron' ,	'Manu' );
INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 2, 'Pastor',	'Guillaume' );
INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 3, 'Sarkozy' ,	'Nico' );
INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 4, 'Biden'   ,	'Joe' );
INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 5, 'Léponge' ,	'Bob' );

SELECT * FROM T_Users;	

-- -----------------------------------------------------------------------------
-- - Construction de la table des catégories 
-- -----------------------------------------------------------------------------



CREATE TABLE T_Categories (
	 IdCategory          int(4)      PRIMARY KEY AUTO_INCREMENT,
	 CatName             varchar(100) NOT NULL,
	 Description         varchar(100) NOT NULL
) ENGINE = InnoDB;


INSERT INTO T_Categories (IdCategory, CatName, Description) VALUES (1, 'Dev Web', 'mise en place site web');
INSERT INTO T_Categories (IdCategory, CatName, Description) VALUES (2, 'CMS', 'initiation CMS');
INSERT INTO T_Categories (IdCategory, CatName, Description) VALUES (3, 'Bureautique', 'initiation PackOffice');
INSERT INTO T_Categories (IdCategory, CatName, Description) VALUES (4, 'CyberSécurité', 'Regex');
INSERT INTO T_Categories (IdCategory, CatName, Description) VALUES (5, 'IA', 'Datas');

ALTER TABLE t_trainings ADD COLUMN IdCategory INT(4);
ALTER TABLE T_Trainings ADD FOREIGN KEY(IdCategory) REFERENCES T_Categories(IdCategory);



SELECT * FROM T_Categories;


-- -----------------------------------------------------------------------------
-- - Construction de la table des commandes
-- -----------------------------------------------------------------------------
CREATE TABLE T_Orders (
	IdOrder				int(4)		PRIMARY KEY AUTO_INCREMENT,
	Amount				float(4)	NOT NULL DEFAULT 0,
	DateOrder 			DATE		NOT NULL DEFAULT NOW(),
	IdCustomer          INT(4)   	NOT NULL,
	FOREIGN KEY(IdCustomer) REFERENCES T_Customers(IdCustomer)
) ENGINE = InnoDB;


SELECT * FROM T_Orders;

-- -----------------------------------------------------------------------------
-- - Construction de la table des commandes de formations
-- -----------------------------------------------------------------------------
CREATE TABLE T_Order_Trainings (
	IdOrderItem			int(4)	PRIMARY KEY AUTO_INCREMENT,
	IdTraining          INT(4)   NOT NULL,
	FOREIGN KEY(IdTraining) REFERENCES T_Trainings(IdTraining),
	Quantity			FLOAT(4) NOT NULL DEFAULT 1,
	UnitaryPrice		FLOAT(4)	NOT NULL DEFAULT 0,
	IdOrder             INT(4)   NOT NULL,
	FOREIGN KEY(IdOrder) REFERENCES T_Orders(IdOrder)
) ENGINE = InnoDB;




-- -----------------------------------------------------------------------------
-- - Un utilisateur avec des droits restreint à une base de données
-- -----------------------------------------------------------------------------

CREATE USER 'guillaume'@'localhost' IDENTIFIED BY'Guiom*31';
GRANT ALL PRIVILEGES ON BDTraining.*TO'guillaume'@'localhost';
FLUSH PRIVILEGES;
mysql -u guillaume -p      password : 
show databases;    						 
show GRANTS FOR ‘guillaume'@'localhost’;  
-- Drop user ‘guillaume'@'localhost’ ->	effacer un utilisateur


