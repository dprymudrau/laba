CREATE DATABASE HospitalsDB;
USE HospitalsDB;

CREATE TABLE CarFleets(
idCarFleet int(2) not null auto_increment PRIMARY KEY,
capacityByCars int(3) not null
);

CREATE TABLE Hospitals(
idHospital int(2) not null auto_increment PRIMARY KEY,
hospitalName varchar(80) not null,
hospitalAddress varchar(50) not null,
idCarFleet int(2),
FOREIGN KEY(idCarFleet) REFERENCES CarFleets(idCarFleet)
ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE Visitors(
idVisitor int not null auto_increment PRIMARY KEY,
visitorName varchar(15) not null,
visitorSurname varchar(15) not null,
visitorDayOfBirth date not null,
visitorAddress varchar(50) not null,
diagnosis varchar(80) not null,
visitDate datetime not null,
dischargeDate datetime
);

CREATE TABLE VisitorCategories(
idVisitorCategory int(1) not null auto_increment PRIMARY KEY,
healthConditionCategory varchar(30) not null,
visitCategory varchar(30) not null
);

CREATE TABLE VisitorAgeGroupCategories(
idVisitorAgeGroupCategory int(1) not null auto_increment PRIMARY KEY,
ageGroupCategory varchar(30) not null
);

CREATE TABLE RegistrationCards(
idRegistrationCard int not null auto_increment PRIMARY KEY,
idHospital int(2) not null,
idVisitor int not null,
idVisitorAgeGroupCategory int(1) not null,
idVisitorCategory int(1) not null,
FOREIGN KEY(idHospital) REFERENCES Hospitals(idHospital) ON UPDATE CASCADE ON DELETE RESTRICT,
FOREIGN KEY(idVisitor) REFERENCES Visitors(idVisitor) ON UPDATE CASCADE ON DELETE RESTRICT,
FOREIGN KEY(idVisitorAgeGroupCategory) REFERENCES VisitorAgeGroupCategories(idVisitorAgeGroupCategory) ON UPDATE CASCADE ON DELETE RESTRICT,
FOREIGN KEY(idVisitorCategory) REFERENCES VisitorCategories(idVisitorCategory) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE WorkShifts(
idWorkShift int(1) not null auto_increment PRIMARY KEY,
nameOfShift varchar(20) not null,
clockIn time not null,
clockOut time not null,
idHospital int(2) not null,
FOREIGN KEY(idHospital) REFERENCES Hospitals(idHospital) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE WorkerContracts(
idNumberOfContract int not null PRIMARY KEY,
idHospital int(2) not null,
dateOfSigning date not null,
FOREIGN KEY(idHospital) REFERENCES Hospitals(idHospital) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE WorkPositions(
idWorkPosition int(3) not null auto_increment PRIMARY KEY,
nameOfPosition varchar(30) not null,
nameOfCategory varchar(30) not null
);

CREATE TABLE WorkExperience(
idWorkExp int not null auto_increment PRIMARY KEY,
totalWorkExp varchar(20) not null,
salaryIndex double not null
);

CREATE TABLE Specialities(
idSpeciality int not null auto_increment PRIMARY KEY,
specialityName varchar(45) not null
);

CREATE TABLE Cars(
idCar int(3) not null auto_increment PRIMARY KEY,
carBrandName varchar(15) not null,
carModel varchar(15) not null,
carRegNumber varchar(8) not null,
idCarFleet int(2),
FOREIGN KEY(idCarFleet) REFERENCES CarFleets(idCarFleet) ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE Drivers(
idDriver int not null auto_increment PRIMARY KEY,
driverName varchar(20) not null,
driverSurname varchar(20) not null,
driverDateOfBirth date not null,
idWorkPosition int(3) not null,
idNumberOfContract int not null,
idWorkExp int not null,
FOREIGN KEY(idWorkPosition) REFERENCES WorkPositions(idWorkPosition) ON UPDATE CASCADE ON DELETE RESTRICT,
FOREIGN KEY(idNumberOfContract) REFERENCES WorkerContracts(idNumberOfContract) ON UPDATE CASCADE ON DELETE RESTRICT,
FOREIGN KEY(idWorkExp) REFERENCES WorkExperience(idWorkExp) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE DriverLicenses(
driverLicenseNumber int(8) not null PRIMARY KEY,
driverCategory varchar(10) not null,
idCar int(3) not null,
idDriver int not null,
issueDate date not null,
expirationDate date not null,
FOREIGN KEY(idCar) REFERENCES Cars(idCar) ON UPDATE CASCADE ON DELETE RESTRICT,
FOREIGN KEY(idDriver) REFERENCES Drivers(idDriver) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE Doctors(
idDoctor int not null auto_increment PRIMARY KEY,
doctorName varchar(20) not null,
doctorSurname varchar(20) not null,
doctorDateOfBirth date not null,
idWorkPosition int(3) not null,
idSpecialty int not null,
idNumberOfContract int not null,
idWorkExp int not null,
FOREIGN KEY(idWorkPosition) REFERENCES WorkPositions(idWorkPosition) ON UPDATE CASCADE ON DELETE RESTRICT,
FOREIGN KEY(idSpecialty) REFERENCES Specialities(idSpeciality) ON UPDATE CASCADE ON DELETE RESTRICT,
FOREIGN KEY(idNumberOfContract) REFERENCES WorkerContracts(idNumberOfContract) ON UPDATE CASCADE ON DELETE RESTRICT,
FOREIGN KEY(idWorkExp) REFERENCES WorkExperience(idWorkExp) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE Nurses(
idNurse int not null auto_increment PRIMARY KEY,
nurseName varchar(20) not null,
nurseSurname varchar(20) not null,
nurseDateOfBirth date not null,
idWorkPosition int(3) not null,
idNumberOfContract int not null,
idWorkExp int not null,
FOREIGN KEY(idWorkPosition) REFERENCES WorkPositions(idWorkPosition) ON UPDATE CASCADE ON DELETE RESTRICT,
FOREIGN KEY(idNumberOfContract) REFERENCES WorkerContracts(idNumberOfContract) ON UPDATE CASCADE ON DELETE RESTRICT,
FOREIGN KEY(idWorkExp) REFERENCES WorkExperience(idWorkExp) ON UPDATE CASCADE ON DELETE RESTRICT
);