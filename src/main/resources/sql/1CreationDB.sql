create database ITCompany;
use ItCompany;

-- CTRL+/(num pad) comment all lines

-- DROP TABLE Custumer;
-- DROP TABLE СustomerСontact;
-- DROP TABLE City;
-- DROP TABLE Adress;
-- DROP TABLE Emails;
-- DROP TABLE PhoneNumbers;
-- DROP TABLE ITCompanies;
-- DROP TABLE ITCompanyContact;
-- DROP TABLE DepartmentName;
-- DROP TABLE Project;
-- DROP TABLE Tasks;
-- DROP TABLE TasksStatus;
-- DROP TABLE TasksLevel;
-- DROP TABLE Positione;
-- DROP TABLE Emploee;


-- Creation DB and Filling of the info

create table Сustumer (
	id INT NOT NULL AUTO_INCREMENT,
	custumer VARCHAR(45),
    adressID INT,
	PRIMARY KEY (id),
	FOREIGN KEY (adressID) REFERENCES Adress(id)
		ON DELETE CASCADE
        ON UPDATE NO ACTION
);
SELECT * FROM Сustomer;


create table СustumerСontact (
	id INT NOT NULL AUTO_INCREMENT,
	cCName VARCHAR(45) NOT NULL,
    cCSurname VARCHAR(45) NOT NULL,
    cCPatronymic VARCHAR(45) NOT NULL,
	custumerID INT,
	emailsID INT,    
	phoneNumbersID INT, 
	PRIMARY KEY (id),
	FOREIGN KEY (custumerID) REFERENCES Сustomer(id)
    	ON DELETE CASCADE
		ON UPDATE NO ACTION,
    FOREIGN KEY (emailsID) REFERENCES Emails(id)
    	ON DELETE CASCADE
		ON UPDATE NO ACTION,
    FOREIGN KEY (phoneNumbersID) REFERENCES PhoneNumbers(id) 
		ON DELETE CASCADE
        ON UPDATE NO ACTION
);
SELECT * FROM СustomerСontact ;


create table City(
	id INT NOT NULL AUTO_INCREMENT,
	city VARCHAR(45) NOT NULL,
    codeNumber INT NOT NULL,
	adressID INT,
	PRIMARY KEY (id),
	FOREIGN KEY (adressID) REFERENCES Adress(id)
	    ON DELETE CASCADE
        ON UPDATE NO ACTION
);
SELECT * FROM City;


create table Adress(
	id INT NOT NULL AUTO_INCREMENT,
	adress VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
);
SELECT * FROM Adress;


create table Emails(
	id INT NOT NULL AUTO_INCREMENT,
	emails VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
);
SELECT * FROM Emails;


create table PhoneNumbers(
	id INT NOT NULL AUTO_INCREMENT,
	phoneNumbers VARCHAR(45) NOT NULL,  
	PRIMARY KEY (id)
);
SELECT * FROM PhoneNumbers;


create table ITCompanies(
	id INT NOT NULL AUTO_INCREMENT,
	companiName VARCHAR(45) NOT NULL,
    adressID INT,    
	PRIMARY KEY (id),
	FOREIGN KEY (adressID) REFERENCES Adress(id) 
    	ON DELETE CASCADE
        ON UPDATE NO ACTION
);
SELECT * FROM ITCompanies;


create table ITCompanyContact(
	id INT NOT NULL AUTO_INCREMENT,
	iTCCName VARCHAR(45) NOT NULL,
    iTCCSurname VARCHAR(45) NOT NULL,
    iTCCPatronymic VARCHAR(45) NOT NULL,    
    iTCompaniesID INT,
	emailsID INT,
    phoneNumbersID INT,
	custumerContactID INT,
    custumerContactphoneNumberID INT,    
	PRIMARY KEY (id),
	FOREIGN KEY (iTCompaniesID) REFERENCES ITCompanies(id)
		ON DELETE CASCADE
		ON UPDATE NO ACTION,
	FOREIGN KEY (emailsID) REFERENCES Emails(id)
    	ON DELETE CASCADE
		ON UPDATE NO ACTION,
    FOREIGN KEY (phoneNumbersID) REFERENCES PhoneNumbers(id)
    	ON DELETE CASCADE
		ON UPDATE NO ACTION,
    FOREIGN KEY (custumerContactID) REFERENCES СustumerСontact(id)
    	ON DELETE CASCADE
		ON UPDATE NO ACTION,
    FOREIGN KEY (custumerContactphoneNumberID) REFERENCES PhoneNumbers(id) 
    	ON DELETE CASCADE
        ON UPDATE NO ACTION
);
SELECT * FROM ITCompanyContact;

CREATE TABLE DepartmentName (
    id INT NOT NULL AUTO_INCREMENT,
    departmentName VARCHAR(45) NOT NULL,
    itCompaniesId INT,
	PRIMARY KEY (id),
    FOREIGN KEY (iTCompaniesID) REFERENCES ITCompanies(id)
    	ON DELETE CASCADE
        ON UPDATE NO ACTION
);
SELECT * FROM DepartmentName ;


CREATE TABLE Project (
    id INT NOT NULL AUTO_INCREMENT,
	project VARCHAR(45) NOT NULL,
	departmentNameId INT,
    departmentNameIdItCompaniesID INT,
	PRIMARY KEY (id),
	FOREIGN KEY (departmentNameId) REFERENCES DepartmentName(id)
    	ON DELETE CASCADE
		ON UPDATE NO ACTION,
	FOREIGN KEY (departmentNameIdItCompaniesID) REFERENCES ITCompanies(id) 
    	ON DELETE CASCADE
        ON UPDATE NO ACTION
);
SELECT * FROM Orders;


create table Tasks(
	id INT NOT NULL AUTO_INCREMENT,
	task VARCHAR(45) NOT NULL,
    projectID INT,
    emploeeID INT,
    emploeeProjectID INT,
    taskStatusID INT,
    taskLevelID INT,
	PRIMARY KEY (id),
	FOREIGN KEY (projectID) REFERENCES Project(id)
    	ON DELETE CASCADE
		ON UPDATE NO ACTION,
	FOREIGN KEY (emploeeID) REFERENCES Emploee(id)
    	ON DELETE CASCADE
		ON UPDATE NO ACTION,
	FOREIGN KEY (emploeeProjectID) REFERENCES Project(id)
    	ON DELETE CASCADE
		ON UPDATE NO ACTION,
	FOREIGN KEY (taskStatusID) REFERENCES TasksStatus(id)
    	ON DELETE CASCADE
		ON UPDATE NO ACTION,
	FOREIGN KEY (taskLevelID) REFERENCES TasksLevel(id)
    	ON DELETE CASCADE
        ON UPDATE NO ACTION
);
SELECT * FROM Tasks;


create table TasksStatus(
	id INT NOT NULL AUTO_INCREMENT,
	tasksStatus VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
);
SELECT * FROM TasksStatus;


create table TasksLevel(
	id INT NOT NULL AUTO_INCREMENT,
	tasksLevel VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
);
SELECT * FROM TasksLevel;


create table Positione(
	id INT NOT NULL AUTO_INCREMENT,
	positione VARCHAR(45) NOT NULL,
    departmentNameID INT,
    departmentNameItCompaniesID INT, 
	PRIMARY KEY (id),
	FOREIGN KEY (departmentNameID) REFERENCES DepartmentName(id)
    	ON DELETE CASCADE
		ON UPDATE NO ACTION,
	FOREIGN KEY (departmentNameItCompaniesID) REFERENCES ITCompanys(id)
    	ON DELETE CASCADE
        ON UPDATE NO ACTION
);
SELECT * FROM Positione;


create table Emploee ( 
	id INT NOT NULL AUTO_INCREMENT,
	cCName VARCHAR(45) NOT NULL,
    cCSurname VARCHAR(45) NOT NULL,
    cCPatronymic VARCHAR(45) NOT NULL,    
    positioneID INT,
    projectID INT,
	PRIMARY KEY (id),
    FOREIGN KEY (positioneID) REFERENCES Positione(id)
    	ON DELETE CASCADE
		ON UPDATE NO ACTION,
	FOREIGN KEY (projectID) REFERENCES Project(id)
    	ON DELETE CASCADE
        ON UPDATE NO ACTION
);
SELECT * FROM Emploee ;


