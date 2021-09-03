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
    itCompaniesId INT,
    itCompaniСompanyAdressId INT,
    departmentTypeId INT,
    departmentType VARCHAR(45),
	PRIMARY KEY (id),
    FOREIGN KEY (iTCompaniesID) REFERENCES ITCompanies(id),
    FOREIGN KEY (itCompaniСompanyAdressId) REFERENCES Adress(id),
	FOREIGN KEY (departmentTypeId) REFERENCES Emploee(id)
);
SELECT * FROM DepartmentName;


CREATE TABLE Orders (
    id INT NOT NULL AUTO_INCREMENT,
	departmentTypeId INT,
    departmentItCompaniID INT,
    departmentItCompaniСompanyAdressId INT,
    departmentTypeID INT,
    departmentType VARCHAR(45),
	PRIMARY KEY (id),
	FOREIGN KEY (departmentTypeId) REFERENCES Emploee(id),
	FOREIGN KEY (departmentItCompaniID) REFERENCES ITCompanies(id),
	FOREIGN KEY (departmentTypeID) REFERENCES DepartmentName(id)    
);
SELECT * FROM Orders;


create table Tasks(
	id INT NOT NULL AUTO_INCREMENT,
	task VARCHAR(45) NOT NULL,
    taskStasusId INT,
    iTCompanyContact INT,
    iTCompanyContactPhoneNumbersID INT,
    iTCompanyContactEmailsID INT,
    iTCompanyContactAdressID INT,
	PRIMARY KEY (id),
	FOREIGN KEY (taskStasusId) REFERENCES TasksStatus(id),
	FOREIGN KEY (iTCompanyContact) REFERENCES ITCompanyContact(id),
	FOREIGN KEY (iTCompanyContactPhoneNumbersID) REFERENCES PhoneNumbers(id),
	FOREIGN KEY (iTCompanyContactEmailsID) REFERENCES Emails(id),
	FOREIGN KEY (iTCompanyContactAdressID) REFERENCES Adress(id)
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
    tasksID INT,
	PRIMARY KEY (id),
	FOREIGN KEY (tasksID) REFERENCES Tasks(id)
);
SELECT * FROM TasksLevel;


create table ITCompanies(
	id INT NOT NULL AUTO_INCREMENT,
	companyName VARCHAR(45) NOT NULL,
    companyAdressID INT,    
	PRIMARY KEY (id),
	FOREIGN KEY (companyAdressID) REFERENCES Adress(id)    
);
SELECT * FROM ITCompanies;


create table ITCompanyContact(
	id INT NOT NULL AUTO_INCREMENT,
	iTCCName VARCHAR(45) NOT NULL,
    iTCCSurname VARCHAR(45) NOT NULL,
    iTCCPatronymic VARCHAR(45) NOT NULL,
    phoneNumbersID INT,
    emailsID INT,
    adressID INT,
    iTCompaniesID INT,
    iTCompaniesCompanyAdressID INT,
    cityID INT,
    cityPhoneNumbersID INT,
    cityAdressID INT,
    cityCodeID INT,
    cityCodeCodeCol VARCHAR(45),
    adressID INT,
    adressAdressCol VARCHAR(45),
    adressMainOfiseAdewss VARCHAR(45),
    adressCustumerID INT,
    adressCustumerCompanyName VARCHAR(45),
    adressCustumerContactID INT,
    adressCustumerCompanyAdressID INT,
	PRIMARY KEY (id),
	FOREIGN KEY (phoneNumbersID) REFERENCES PhoneNumbers(id),
	FOREIGN KEY (emailsID) REFERENCES Emails(id),
    FOREIGN KEY (adressID) REFERENCES Adress(id),
    FOREIGN KEY (iTCompaniesID) REFERENCES ITCompanies(id),
    FOREIGN KEY (iTCompaniesCompanyAdressID) REFERENCES Adress(id),
    FOREIGN KEY (cityID) REFERENCES City(id),
    FOREIGN KEY (cityPhoneNumbersID) REFERENCES PhoneNumbers(id),
    FOREIGN KEY (cityAdressID) REFERENCES Adress(id),
    FOREIGN KEY (cityCodeID) REFERENCES City(id),
    FOREIGN KEY (adressID) REFERENCES СustomerСontact(id),
    FOREIGN KEY (adressCustumerID) REFERENCES СustomerСontact(id),
	FOREIGN KEY (adressCustumerContactID) REFERENCES СustomerСontact(id),
	FOREIGN KEY (adressCustumerCompanyAdressID) REFERENCES Adress(id)
);
SELECT * FROM ITCompanyContact;

create table Сustomer (
	id INT NOT NULL AUTO_INCREMENT,
	companyName VARCHAR(45),
    custumerContactID INT,
    custumerAdressID INT,
	PRIMARY KEY (id),
	FOREIGN KEY (custumerContactID) REFERENCES СustomerСontact(id),
	FOREIGN KEY (custumerAdressID) REFERENCES Adress(id)
);
SELECT * FROM Сustomer;

create table СustomerСontact (
	id INT NOT NULL AUTO_INCREMENT,
	cCName VARCHAR(45) NOT NULL,
    cCSurname VARCHAR(45) NOT NULL,
    cCPatronymic VARCHAR(45) NOT NULL,
	emailsID INT,
    phoneNumbersID INT,
	custumerID INT,
    custumerCompanyName VARCHAR(45),
	adressCustumerContactID INT,
    adressCustumerCompanyAdressID INT,
	adressID INT,    
    adressAdressCol VARCHAR(45),
    mainOfiseAdress VARCHAR(45),
	adressСustomerID INT,
    adressСustomerCompanyName VARCHAR(45),
    adressСustomerCompanyContactID INT,
    adressСustomerCompanyAdressID INT,    
	PRIMARY KEY (id),
    FOREIGN KEY (emailsID) REFERENCES Emails(id),
    FOREIGN KEY (phoneNumbersID) REFERENCES PhoneNumbers(id),
    FOREIGN KEY (custumerID) REFERENCES Сustomer(id),
	FOREIGN KEY (adressCustumerContactID) REFERENCES СustomerСontact(id),
	FOREIGN KEY (adressCustumerCompanyAdressID) REFERENCES Adress(id),
	FOREIGN KEY (adressID) REFERENCES СustomerСontact(id),
	FOREIGN KEY (adressСustomerID) REFERENCES Adress(id),
    FOREIGN KEY (adressСustomerCompanyContactID) REFERENCES ITCompanyContact(id),
    FOREIGN KEY (adressСustomerCompanyAdressID) REFERENCES ITCompanyContact(id)    
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
	codeNumber VARCHAR(45) NOT NULL,
	custumerID INT,
    custumerCompanyName VARCHAR(45),
	adressСustomerCompanyContactID INT,
    adressСustomerCompanyAdressID INT, 
	PRIMARY KEY (id),
	FOREIGN KEY (custumerID) REFERENCES Сustomer(id),
	FOREIGN KEY (adressСustomerCompanyContactID) REFERENCES ITCompanyContact(id),
    FOREIGN KEY (adressСustomerCompanyAdressID) REFERENCES ITCompanyContact(id)
);
SELECT * FROM City;


create table PhoneNumbers(
	id INT NOT NULL AUTO_INCREMENT,
	phoneNumberscol VARCHAR(45) NOT NULL,
    cityID INT,
    cityPhoneNumbersID INT,
    cityAdressID INT,
    cityCodeID INT,
    cityCodeCol VARCHAR(45),    
	PRIMARY KEY (id),
    FOREIGN KEY (cityID) REFERENCES City(id),
    FOREIGN KEY (cityPhoneNumbersID) REFERENCES PhoneNumbers(id),
    FOREIGN KEY (cityAdressID) REFERENCES Adress(id),
    FOREIGN KEY (cityCodeID) REFERENCES City(codeNumber)
);
SELECT * FROM PhoneNumbers;


create table Adress(
	id INT NOT NULL AUTO_INCREMENT,
	adress VARCHAR(45) NOT NULL,
    cityID INT,
    cityPhoneNunbers INT,
	cityAdressID INT,
    cityCodeID INT,
    cityCodeCol VARCHAR(45),
    mainOfiseAdress VARCHAR(45),
    adressCol VARCHAR(45),
    custumerID INT,
	custumerCompanyName VARCHAR(45),
    custumerContactID INT,
    custumerAdressID INT,
    itCompaniesID INT,
    itCompaniewCompanyAdressID INT,
	PRIMARY KEY (id),
    FOREIGN KEY (cityID) REFERENCES City(id),
    FOREIGN KEY (cityPhoneNunbers) REFERENCES PhoneNumbers(id),
    FOREIGN KEY (cityAdressID) REFERENCES Adress(id),
    FOREIGN KEY (cityCodeID) REFERENCES CityCode(id),
    FOREIGN KEY (cityCodeCol) REFERENCES CityCode(id),
    FOREIGN KEY (custumerID) REFERENCES Сustomer(id),
    FOREIGN KEY (custumerContactID) REFERENCES СustomerСontact(id),
    FOREIGN KEY (itCompaniesID) REFERENCES iTCompanys(id),
	FOREIGN KEY (itCompaniewCompanyAdressID) REFERENCES iTCompanys(id)
);
SELECT * FROM Adress;


create table Positione(
	id INT NOT NULL AUTO_INCREMENT,
	positione VARCHAR(45) NOT NULL,
    itCompanyID INT,
    itCompanyAdress INT, 
	PRIMARY KEY (id),
	FOREIGN KEY (itCompanyID) REFERENCES ITCompanys(id),
	FOREIGN KEY (itCompanyAdress) REFERENCES adress(id)
);
SELECT * FROM Positione;



create table Emploee ( 
	id INT NOT NULL AUTO_INCREMENT,
	cCName VARCHAR(45) NOT NULL,
    cCSurname VARCHAR(45) NOT NULL,
    cCPatronymic VARCHAR(45) NOT NULL,
    iTCompanies INT,
    departmentType INT,
    itCompanyId INT,
    iTCompanyAdressID INT,
    departmentTypeID INT,
    departmentType VARCHAR(45),
	PRIMARY KEY (id),
    FOREIGN KEY (iTCompaniesID) REFERENCES ITCompanies(id),
	FOREIGN KEY (departmentType) REFERENCES DepartmentName(id),
	FOREIGN KEY (itCompanyId) REFERENCES ITCompanies(id),
	FOREIGN KEY (iTCompanyAdressID) REFERENCES Adress(id),
	FOREIGN KEY (departmentTypeID) REFERENCES DepartmentName(id)
);
SELECT * FROM Emploee ;


