create database ITCompany;
use ItCompany;

-- CTRL+/(num pad) comment all lines
-- DROP TABLE DepartmentName;
-- -- DROP TABLE Order;
-- DROP TABLE Tasks;
-- DROP TABLE TasksStatus;
-- DROP TABLE TasksLevel;
-- DROP TABLE ITCompanys;
-- DROP TABLE ITCompanyContact;
-- -- DROP TABLE  Custumer;

-- DROP TABLE СustomerСontact;
-- DROP TABLE Emails;
-- DROP TABLE City;
-- DROP TABLE CityCode;
-- DROP TABLE PhoneNumbers;
-- DROP TABLE Adress;
-- -- DROP TABLE  MainOfiseAdress;
-- -- DROP TABLE  City_has_ITCompany;
-- DROP TABLE Positione;
-- DROP TABLE Emploee;


-- Creation DB and Filling of the info

CREATE TABLE DepartmentName (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);
SELECT * FROM DepartmentName;

-- create table Order

create table Tasks(
	id INT NOT NULL AUTO_INCREMENT,
	task VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
    -- TasksStatus_id
    -- ITCompanyContact_id
    -- ITCompanyContact_PhoneNumbers_id
    -- ITCompanyContact_Emails_id
    -- ITCompanyContact_Adress_id
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


create table ITCompanys(
	id INT NOT NULL AUTO_INCREMENT,
	companyName VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
    -- CompanyAdress_id
);
SELECT * FROM ITCompanys;



create table ITCompanyContact(
	id INT NOT NULL AUTO_INCREMENT,
	iTCCName VARCHAR(45) NOT NULL,
    iTCCSurname VARCHAR(45) NOT NULL,
    iTCCPatronymic VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
    -- PhoneNumbers_id
    -- Emails_id
    -- Adress_id
    
    -- ITCompanys_id
    -- ITCompanys_CompanyAdress_id
    -- City_id
    -- City_PhoneNumbers_id
    -- City_Adress_id
    -- City_CityCode_id
    -- City_CityCode_CityCodecol
);
SELECT * FROM ITCompanyContact;


-- create table Custumer


create table СustomerСontact (
	id INT NOT NULL AUTO_INCREMENT,
	cCName VARCHAR(45) NOT NULL,
    cCSurname VARCHAR(45) NOT NULL,
    cCPatronymic VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
    -- PhoneNumbers_id
    -- Emails_id
    -- CompanyAdress_id
    
    -- Custumer_id
    -- Custumer_companyName
    -- Custumer_СustomerСontact_id
    -- Custumer_CompanyAdress_id


);
SELECT * FROM СustomerСontact ;



create table Emails(
	id INT NOT NULL AUTO_INCREMENT,
	emailAdress VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)

);
SELECT * FROM Emails;


create table City(
	id INT NOT NULL AUTO_INCREMENT,
	cityName VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
	-- PhoneNumbers_id
    -- Custumer_id
    -- Custumer_companyName
    -- Custumer_СustomerСontact_id
    -- Custumer_CompanyAdress_id
    -- Adress_id
    -- CityCode_id
    -- CityCode_CityCodecol
);
SELECT * FROM City;


create table CityCode(
	id INT NOT NULL AUTO_INCREMENT,
	codeNumber VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
);
SELECT * FROM CityCode;


create table PhoneNumbers(
	id INT NOT NULL AUTO_INCREMENT,
	phoneNumberscol VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)

);
SELECT * FROM PhoneNumbers;



create table Adress(
	id INT NOT NULL AUTO_INCREMENT,
	adress VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
	-- City_id
    -- City_PhoneNumbers_id
    -- City_Adress_id
    -- City_CityCode_id
    -- City_CityCode_CityCodecol
    -- MainOfiseAdress_id
);
SELECT * FROM Adress;


-- create table MainOfiseAdress

-- create table City_has_ITCompany

create table Positione(
	id INT NOT NULL AUTO_INCREMENT,
	positione VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
	-- ITCompany_id
    -- ITCompany_CompanyAdress_id
);
SELECT * FROM Positione;



create table Emploee ( 
	id INT NOT NULL AUTO_INCREMENT,
	cCName VARCHAR(45) NOT NULL,
    cCSurname VARCHAR(45) NOT NULL,
    cCPatronymic VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
    -- ITCompany_id
    -- Position_id
    -- Departments_id
    -- Departments_ITCompany_id
    -- Departments_ITCompany_CompanyAdress_id
    -- Departments_departmentType_id
    -- Departments_departmentType

);
SELECT * FROM Emploee ;


-- 10: DELETE, UPDATE, LEFT, RIGHT, INNER

DELETE FROM Emploee WHERE cCName = 'Name1';
