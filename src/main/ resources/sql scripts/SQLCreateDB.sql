CREATE DATABASE AirportTickets;
USE AirportTickets;

CREATE TABLE PassengerAccount(
	idPassengerAccount INT PRIMARY KEY AUTO_INCREMENT,
    passportNumber VARCHAR(45) UNIQUE NOT NULL,
    fullName VARCHAR(75) NOT NULL
);

CREATE TABLE Passenger (
	idPassenger INT PRIMARY KEY AUTO_INCREMENT,
    accountId INT NOT NULL UNIQUE,
    passengerName VARCHAR(45) NOT NULL,
    phoneNumber VARCHAR(19) NOT NULL,
    FOREIGN KEY (accountId) REFERENCES PassengerAccount(idPassengerAccount) ON DELETE CASCADE
);

CREATE TABLE FlightCategory (
	idFlightCategory INT PRIMARY KEY AUTO_INCREMENT,
    flightCategoryName VARCHAR(45) NOT NULL
);

CREATE TABLE PlaneModel (
	idPlaneModel INT PRIMARY KEY AUTO_INCREMENT,
    capacity INT NOT NULL,
	planeModelName VARCHAR(45) NOT NULL
);

CREATE TABLE Country (
	idCountry INT PRIMARY KEY AUTO_INCREMENT,
    countryName VARCHAR(45) NOT NULL
);

CREATE TABLE Town (
	idTown INT PRIMARY KEY AUTO_INCREMENT,
    countryId INT NOT NULL,
    townName VARCHAR(45) NOT NULL,
    FOREIGN KEY (countryId) REFERENCES Country(idCountry) ON DELETE CASCADE
);

CREATE TABLE Airport (
	idAirport INT PRIMARY KEY AUTO_INCREMENT,
    townId INT NOT NULL,
    airportName VARCHAR(45) NOT NULL,
    passengersPerDay INT NOT NULL,
    FOREIGN KEY (townId) REFERENCES Town(idTown) ON DELETE CASCADE
);

CREATE TABLE Company (
	idCompany INT PRIMARY KEY AUTO_INCREMENT,
    companyName VARCHAR(45) NOT NULL,
    companyDescription MEDIUMTEXT
);

CREATE TABLE FlightWay (
	idFlightWay INT PRIMARY KEY AUTO_INCREMENT,
    fromAirportId INT NOT NULL,
    whereAirportId INT NOT NULL,
    companyId INT NOT NULL,
    FOREIGN KEY (fromAirportId) REFERENCES Airport(idAirport) ON DELETE CASCADE,
    FOREIGN KEY (whereAirportId) REFERENCES Airport(idAirport) ON DELETE CASCADE,
    FOREIGN KEY (companyId) REFERENCES Company(idCompany) ON DELETE CASCADE
);

CREATE TABLE Plane (
	idPlane INT PRIMARY KEY AUTO_INCREMENT,
	companyId INT NOT NULL,
	modelId INT NOT NULL,
    serialNumber INT UNIQUE,
    FOREIGN KEY (companyId) REFERENCES Company(idCompany) ON DELETE CASCADE,
    FOREIGN KEY (modelId) REFERENCES PlaneModel(idPlaneModel) ON DELETE CASCADE
);

CREATE TABLE PilotCategory(
	idPilotCategory INT PRIMARY KEY AUTO_INCREMENT,
    pilotCategoryName VARCHAR(45) NOT NULL
);

CREATE TABLE Pilot(
	idPilot INT PRIMARY KEY AUTO_INCREMENT,
    companyId INT NOT NULL,
    pilotCategoryId INT NOT NULL,
    pilotName VARCHAR(45) NOT NULL,
    workExperience INT NOT NULL,
    FOREIGN KEY (companyId) REFERENCES Company(idCompany) ON DELETE CASCADE,
    FOREIGN KEY (pilotCategoryId) REFERENCES PilotCategory(idPilotCategory) ON DELETE CASCADE
);

CREATE TABLE Flight(
	idFlight INT PRIMARY KEY AUTO_INCREMENT,
    pilotId INT NOT NULL,
    planeId INT NOT NULL,
    flightWayId INT NOT NULL,
    categoryId INT NOT NULL,
    price INT NOT NULL,
    flightDate DATETIME NOT NULL,
    FOREIGN KEY (pilotId) REFERENCES Pilot(idPilot) ON DELETE CASCADE,
    FOREIGN KEY (planeId) REFERENCES Plane(idPlane) ON DELETE CASCADE,
    FOREIGN KEY (categoryId) REFERENCES FlightCategory(idFlightCategory) ON DELETE CASCADE,
    FOREIGN KEY (flightWayId) REFERENCES FlightWay(idFlightWay) ON DELETE CASCADE
);

CREATE TABLE Ticket (
	idTicket INT PRIMARY KEY AUTO_INCREMENT,
    passengerId INT NOT NULL,
    flightId INT NOT NULL,
    placeNumber INT NOT NULL,
    dateOfBuying DATETIME NOT NULL,
    FOREIGN KEY (passengerId) REFERENCES Passenger(idPassenger) ON DELETE CASCADE,
    FOREIGN KEY (flightId) REFERENCES Flight(idFlight) ON DELETE CASCADE
);