USE HospitalsDB;

INSERT INTO CarFleets(capacityByCars)
VALUES
(8),
(42),
(5),
(10);

INSERT INTO Hospitals(hospitalName, hospitalAddress, idCarFleet)
VALUES
('Municipal Gynecological Hospital', 'Minsk, Sennitskaya 53', 1),
('Ambulance Hospital', 'Minsk, Kizhevatova 58', 2),
('Center of Surgery and Transplantology', 'Semashko 8', 2),
('Municipal Clinical Hospital named Savchenko', 'Minsk, Roza Luksenburg 110', 2),
('Municipal Clinical Psychiatric Dispensary', 'Minsk, Behtereva 5', 3),
('Municipal Clinical Narcological Dispensary', 'Minsk, Gastely 16', 3),
('LODE', 'Nezavisimosti 58', 4),
('Municipal Clinical Hospital for Infectious Disease', 'Kropotkina 76', 2);

INSERT INTO WorkShifts(nameOfShift, clockIn, clockOut, idHospital)
VALUES
('Morning shift', '06:00:00', '14:00:00', 2),
('Day shift', '14:00:00', '22:00:00', 2),
('Night shift', '22:00:00', '06:00:00', 2),
('Early Day shift', '08:30:00', '13:00:00', 4),
('Normal Day shift', '13:00:00', '19:00:00', 4),
('12 Hours Day shift', '08:00:00', '20:00:00', 5),
('Morning shift', '09:00:00', '14:00:00', 6),
('Day shift', '12:30:00', '18:30:00', 6);

INSERT INTO Visitors(visitorName, visitorSurname, visitorDayOfBirth, visitorAddress, diagnosis, visitDate, dischargeDate)
VALUES
('Vasya', 'Pupkin', '1978-09-22', 'Minsk, Nezavisimosti 8', 'Alcoholism', '2021-10-11', null),
('Alexey', 'Puplikov', '1992-07-04', 'Minsk, Masherova 104', 'Wickness', '2021-10-11', null),
('Alexandr', 'Lukash', '1954-08-30', 'Minsk, Drozdi 12', 'Manic schizophrenia due to alcoholism', '2021-10-11', null),
('Erast', 'Fandorin', '2008-11-15', 'Minsk, Lenina 246', 'Covid', '2021-10-11', null),
('Anatoliy', 'Rogochev', '1955-08-24', 'Minsk, Stolipina 114', 'Viral respiratory infection', '2021-10-11', null),
('Vitaliy', 'Korobich', '1985-11-19', 'Minsk, Nezavisimosti 134', 'Viral respiratory infection', '2021-10-11', null);

INSERT INTO VisitorCategories(healthConditionCategory, visitCategory)
VALUES
('Healthy', 'Prophylactic examination'),
('Healthy', 'After recovery'),
('Sick', 'Initial inspection'),
('Sick', 'Secondary inspection'),
('Seriously ill', 'Initial inspection'),
('Seriously ill', 'Secondary inspection'),
('Death', 'Medical examination');

INSERT INTO VisitorAgeGroupCategories(ageGroupCategory)
VALUES
('Infant'),
('Teenager'),
('Adult'),
('Aged');

INSERT INTO RegistrationCards(idHospital, idVisitor, idVisitorAgeGroupCategory, idVisitorCategory)
VALUES
(5, 3, 4, 5),
(7, 2, 3, 2),
(2, 4, 2, 2),
(6, 1, 3, 3),
(4, 5, 4, 3),
(4, 6, 3, 3);

INSERT INTO WorkerContracts(idNumberOfContract, idHospital, dateOfSigning)
VALUES
(215602, 5, '2009-01-27'),
(357234, 5, '2011-09-10'),
(132747, 2, '2001-06-03'),
(134551, 2, '1998-10-04'),
(134690, 2, '1999-03-01'),
(629265, 4, '1999-08-15'),
(634795, 4, '2017-11-01'),
(758273, 6, '2020-09-02'),
(126573, 6, '2001-02-18'),
(1212, 7, '2000-01-01'),
(1313, 8, '2000-02-02'),
(1414, 8, '2000-03-03');

INSERT INTO WorkPositions(nameOfPosition, nameOfCategory)
VALUES
('Driver', 'Technical personnel'),
('Nurse', 'Middle medical personnel'),
('Head Nurse', 'Middle medical personnel'),
('Doctor', 'High medical personnel');

INSERT INTO WorkExperience(totalWorkExp, salaryIndex)
VALUES
('Less then 1 year', '1.0'),
('1 year till 3 years', 1.2),
('From 3 to 5', 1.3),
('More 5 years', 1.5);

INSERT INTO Specialities(specialityName)
VALUES
('Pediatrics'),
('Gynecologist'),
('Therapist'),
('Expert in narcology'),
('Psychiatrist'),
('Virologist'),
('Pulmonologist');

INSERT INTO Cars(carBrandName, carModel, carRegNumber, idCarFleet)
VALUES
('Ford', 'Tranzit', '5326PA-7', 1),
('Mercedes-Benz', 'Sprinter', '2005TE-7', 2),
('GAZ', '32214 "Gazel"', '6351TE-7', 3),
('GAZ', '2217 "Sobol"', '4236BC-7', 2),
('Peugeot', 'Boxer', '0957KC-7', 2),
('UAZ', '452', '1488MH-7', 3);

INSERT INTO Drivers(driverName, driverSurname, driverDateOfBirth, idWorkPosition, idNumberOfContract, idWorkExp)
VALUES
('Alexandr', 'Stuzhev', '1991-02-27', 1, 357234, 4),
('Anatoliy', 'Zapashniy', '1981-04-19', 1, 758273, 2),
('Vasiliy', 'Terkin', '1987-08-31', 1, 634795, 3);

INSERT INTO DriverLicenses(driverLicenseNumber, driverCategory, idCar, idDriver, issueDate, expirationDate)
VALUES
(001, 'B, C', 3, 2, '2020-09-02', '2022-09-02'),
(002, 'A, B, C', 1, 3, '2017-11-01', '2021-11-01'),
(003, 'A, C', 6, 1, '2011-09-10', '2022-09-10');

INSERT INTO Doctors(doctorName, doctorSurname, doctorDateOfBirth, idWorkPosition, idSpecialty, idNumberOfContract , idWorkExp)
VALUES
('Pavel', 'Dorofeev', '1974-09-09', 4, 4, 215602, 4),
('Kseniya', 'Dzuba', '1980-04-17', 4, 1, 629265, 4),
('Anastasiya', 'Volframovna', '1976-01-09', 4, 3, 132747, 4),
('Kirill', 'Vakulenko', '1980-02-19', 4, 6, 1313, 4),
('Nazar', 'Lesichanskiy', '1980-04-24', 4, 6, 1414, 4),
('Anastasiya', 'Perepelkina', '1981-01-02', 4, 7, 1212, 4);

INSERT INTO Nurses(nurseName, nurseSurname, nurseDateOfBirth, idWorkPosition, idNumberOfContract, idWorkExp)
VALUES
('Valentina', 'Pereverzeva', '1980-07-19', 2, 126573, 4),
('Nikolay', 'Afanasiev', '1982-10-23', 2, 134690, 4),
('Tatyana', 'Burkovskaya', '1978-01-02', 3, 134551, 4);