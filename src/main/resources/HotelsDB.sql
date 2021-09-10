CREATE DATABASE HospitalsDB;
USE HospitalsDB;

CREATE TABLE CarFleets(
idCarFleet int(2) not null auto_increment,
capacityByCars int(3) not null,
PRIMARY KEY(idCarFleet)
);

CREATE TABLE Hospitals(
idHospital int(2) not null auto_increment,
hospitalName varchar(80) not null,
hospitalAddress varchar(50) not null,
idCarFleet int(2),
PRIMARY KEY(idHospital),
FOREIGN KEY(idCarFleet) REFERENCES CarFleets(idCarFleet)
);

CREATE TABLE Visitors(
idVisitor int not null auto_increment,
visitorName varchar(15) not null,
visitorSurname varchar(15) not null,
visitorDayOfBirth date not null,
visitorAddress varchar(50) not null,
diagnosis varchar(80) not null,
visitDate datetime not null,
dischargeDate datetime,
PRIMARY KEY(idVisitor)
);

CREATE TABLE VisitorCategories(
idVisitorCategory int(1) not null auto_increment,
healthConditionCategory varchar(30) not null,
visitCategory varchar(30) not null,
PRIMARY KEY(idVisitorCategory)
);

CREATE TABLE VisitorAgeGroupCategories(
idVisitorAgeGroupCategory int(1) not null auto_increment,
ageGroupCategory varchar(30) not null,
PRIMARY KEY(idVisitorAgeGroupCategory)
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

CREATE TABLE WorkShifts(
idWorkShift int(1) not null auto_increment,
nameOfShift varchar(20) not null,
clockIn time not null,
clockOut time not null,
idHospital int(2) not null,
PRIMARY KEY(idWorkShift),
FOREIGN KEY(idHospital) REFERENCES Hospitals(idHospital)
);

CREATE TABLE WorkerContracts(
idNumberOfContract int not null,
idHospital int(2) not null,
dateOfSigning date not null,
PRIMARY KEY(idNumberOfContract),
FOREIGN KEY(idHospital) REFERENCES Hospitals(idHospital)
);

CREATE TABLE WorkPositions(
idWorkPosition int(3) not null auto_increment,
nameOfPosition varchar(30) not null,
nameOfCategory varchar(30) not null,
PRIMARY KEY(idWorkPosition)
);

CREATE TABLE WorkExpirience(
idWorkExp int not null auto_increment,
totalWorkExp varchar(20) not null,
salaryIndex double not null,
PRIMARY KEY(idWorkExp)
);

CREATE TABLE Specialities(
idSpeciality int not null auto_increment,
specialityName varchar(45) not null,
PRIMARY KEY(idSpeciality)
);

CREATE TABLE Cars(
idCar int(3) not null auto_increment,
carBrandName varchar(15) not null,
carModel varchar(15) not null,
carRegNumber varchar(8) not null,
idCarFleet int(2) not null,
PRIMARY KEY(idCar),
FOREIGN KEY(idCarFleet) REFERENCES CarFleets(idCarFleet)
);

CREATE TABLE Drivers(
idDriver int not null auto_increment,
driverName varchar(20) not null,
driverSurname varchar(20) not null,
driverDateOfBirth date not null,
idWorkPosition int(3) not null,
idNumberOfContract int not null,
idWorkExp int not null,
PRIMARY KEY(idDriver),
FOREIGN KEY(idWorkPosition) REFERENCES WorkPositions(idWorkPosition),
FOREIGN KEY(idNumberOfContract) REFERENCES WorkerContracts(idNumberOfContract),
FOREIGN KEY(idWorkExp) REFERENCES WorkExpirience(idWorkExp)
);

CREATE TABLE DriverLicenses(
driverLicenseNumber int(8) not null,
driverCategory varchar(10) not null,
idCar int(3) not null,
idDriver int not null,
issueDate date not null,
expirationDate date not null,
PRIMARY KEY(driverLicenseNumber),
FOREIGN KEY(idCar) REFERENCES Cars(idCar),
FOREIGN KEY(idDriver) REFERENCES Drivers(idDriver)
);

CREATE TABLE Doctors(
idDoctor int not null auto_increment,
doctorName varchar(20) not null,
doctorSurname varchar(20) not null,
doctorDateOfBirth date not null,
idWorkPosition int(3) not null,
idSpecialty int not null,
idNumberOfContract int not null,
idWorkExp int not null,
PRIMARY KEY(idDoctor),
FOREIGN KEY(idWorkPosition) REFERENCES WorkPositions(idWorkPosition),
FOREIGN KEY(idSpecialty) REFERENCES Specialities(idSpeciality),
FOREIGN KEY(idNumberOfContract) REFERENCES WorkerContracts(idNumberOfContract),
FOREIGN KEY(idWorkExp) REFERENCES WorkExpirience(idWorkExp)
);

CREATE TABLE Nurses(
idNurse int not null auto_increment,
nurseName varchar(20) not null,
nurseSurname varchar(20) not null,
nurseDateOfBirth date not null,
idWorkPosition int(3) not null,
idNumberOfContract int not null,
idWorkExp int not null,
PRIMARY KEY(idNurse),
FOREIGN KEY(idWorkPosition) REFERENCES WorkPositions(idWorkPosition),
FOREIGN KEY(idNumberOfContract) REFERENCES WorkerContracts(idNumberOfContract),
FOREIGN KEY(idWorkExp) REFERENCES WorkExpirience(idWorkExp)
);