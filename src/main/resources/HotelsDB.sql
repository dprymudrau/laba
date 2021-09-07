CREATE DATABASE HospitalsDB;
USE HospitalsDB;

CREATE TABLE Hospitals(
idHospital int(2) not null auto_increment,
hospitalName varchar(45) not null,
hospitalAddress varchar(45) not null,
idCarFleet int(2),
PRIMARY KEY(idHospital),
FOREIGN KEY(idCarFleet) REFERENCES CarFleets(idCarFleet)
);

CREATE TABLE Visitors(
idVisitor int not null auto_increment,
visitorName varchar(15) not null,
visitorSurname varchar(15) not null,
visitorAddress varchar(45) not null,
diagnosis varchar(45) not null,
visitDate datetime not null,
dischargeDate datetime not null,
PRIMARY KEY(idVisitor)
);

CREATE TABLE RegistrationCards(
idRegistrationCard int not null auto_increment,
idHospital int(2) not null,
idVisitor int not null,
idVisitorAgeGroupCategory int(1) not null,
idVisitorCategory int(1) not null,
PRIMARY KEY(idRegistrationCard),
FOREIGN KEY(idHospital) REFERENCES Hospitals(idHospital),
FOREIGN KEY(idVisitor) REFERENCES Visitors(idVisitor),
FOREIGN KEY(idVisitorAgeGroupCategory) REFERENCES VisitorAgeGroupCategories(idVisitorAgeGroupCategory),
FOREIGN KEY(idVisitorCategory) REFERENCES VisitorCategories(idVisitorCategory)
);

CREATE TABLE VisitorCategories(
idVisitorCategory int(1) not null auto_increment,
healthConditionCategory varchar(20) not null,
visitCategory varchar(20) not null,
PRIMARY KEY(idVisitorCategory)
);

CREATE TABLE VisitorAgeGroupCategories(
idVisitorAgeGroupCategory int(1) not null auto_increment,
ageGroupCategory varchar(20) not null,
PRIMARY KEY(idVisitorAgeGroupCategory)
);

CREATE TABLE CarFleets(
idCarFleet int(2) not null auto_increment,
capacityByCars int(3) not null,
PRIMARY KEY(idCarFleet)
);

CREATE TABLE CarData(
idCarData int(3) not null auto_increment,
carBrandName varchar(15) not null,
carModel varchar(15) not null,
carRegNumber varchar(8) not null,
idCarFleet int(2) not null,
PRIMARY KEY(idCarData),
FOREIGN KEY(idCarFleet) REFERENCES CarFleets(idCarFleet)
);

CREATE TABLE DriverLicenses(
driverLicenseNumber int(8) not null,
driverCategory varchar(10) not null,
idCarData int(3) not null,
idDriver int not null,
issueDate date not null,
expirationDate date not null,
PRIMARY KEY(driverLicenseNumber),
FOREIGN KEY(idCarData) REFERENCES CarData(idCarData),
FOREIGN KEY(idDriver) REFERENCES Drivers(idDriver)
);

CREATE TABLE WorkShifts(
idWorkShift int(1) not null auto_increment,
nameOfShift varchar(15) not null,
clockIn datetime not null,
clockOut datetime not null,
idHospital int(2) not null,
idCarFleet int(2) not null,
PRIMARY KEY(idWorkShift),
FOREIGN KEY(idHospital) REFERENCES Hospitals(idHospital),
FOREIGN KEY(idCarFleet) REFERENCES CarFleets(idCarFleet)
);

CREATE TABLE WorkerContracts(
idWorkerContract int not null,
idHospital int(2) not null,
idWorkPosition int(3) not null,
idWorkShift int(1) not null,
dateOfSigning date not null,
PRIMARY KEY(idWorkerContract),
FOREIGN KEY(idHospital) REFERENCES Hospitals(idHospital),
FOREIGN KEY(idWorkPosition) REFERENCES WorkPositions(idWorkPosition),
FOREIGN KEY(idWorkShift) REFERENCES WorkShifts(idWorkShift)
);

CREATE TABLE WorkPositions(
idWorkPosition int(3) not null auto_increment,
nameOfPosition varchar(20) not null,
nameOfCategory varchar(20) not null,
PRIMARY KEY(idWorkPosition)
);

CREATE TABLE Drivers(
idDriver int not null auto_increment,
driverName varchar(20) not null,
driverSurname varchar(20) not null,
driverDateOfBirth date not null,
idWorkPosition int not null,
totalWorkExp int not null,
PRIMARY KEY(idDriver),
FOREIGN KEY(idWorkPosition) REFERENCES WorkPositions(idWorkPosition),
FOREIGN KEY(totalWorkExp) REFERENCES WorkExpirience(totalWorkExp)
);

CREATE TABLE Doctors(
idDoctor int not null auto_increment,
doctorName varchar(20) not null,
doctorSurname varchar(20) not null,
doctorDateOfBirth date not null,
idWorkPosition int not null,
idSpecialty int not null,
totalWorkExp int not null,
PRIMARY KEY(idDoctor),
FOREIGN KEY(idWorkPosition) REFERENCES WorkPositions(idWorkPosition),
FOREIGN KEY(idSpecialty) REFERENCES Specialities(idSpeciality),
FOREIGN KEY(totalWorkExp) REFERENCES WorkExpirience(totalWorkExp)
);

CREATE TABLE Nurses(
idNurse int not null auto_increment,
nurseName varchar(20) not null,
nurseSurname varchar(20) not null,
nurseDateOfBirth date not null,
idWorkPosition int not null,
totalWorkExp int not null,
PRIMARY KEY(idNurse),
FOREIGN KEY(idWorkPosition) REFERENCES WorkPositions(idWorkPosition),
FOREIGN KEY(totalWorkExp) REFERENCES WorkExpirience(totalWorkExp)
);

CREATE TABLE Specialities(
idSpeciality int not null auto_increment,
specialityName varchar(45) not null,
PRIMARY KEY(idSpeciality)
);

CREATE TABLE WorkExpirience(
totalWorkExp int not null,
salaryIndex double not null,
PRIMARY KEY(totalWorkExp)
);