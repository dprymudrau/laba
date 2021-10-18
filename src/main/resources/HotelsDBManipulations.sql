USE HospitalsDB;

SELECT * FROM Cars;
SELECT * FROM CarFleets;
SELECT c.idCar, c.carBrandName, c.carModel, c.carRegNumber, cf.capacityByCars FROM Cars c
RIGHT JOIN CarFleets cf ON c.idCarFleet=cf.idCarFleet;
SELECT * FROM Cars WHERE idCarFleet = 3;
SELECT * FROM CarFleets WHERE idCarFleet = 3;

SELECT * FROM Hospitals;
SELECT h.hospitalName, h.hospitalAddress, c.capacityByCars FROM Hospitals h
LEFT JOIN CarFleets c ON h.idCarFleet=c.idCarFleet;
SELECT h.idHospital, h.hospitalName, h.hospitalAddress, c.capacityByCars FROM Hospitals h 
LEFT JOIN CarFleets c ON h.idCarFleet=c.idCarFleet
ORDER BY h.idHospital;

SELECT * FROM Visitors;
SELECT * FROM VisitorCategories;
SELECT * FROM VisitorAgeGroupCategories;
SELECT * FROM Hospitals;

SELECT rc.idRegistrationCard, h.hospitalName, v.visitorName, v.visitorSurname, vagc.ageGroupCategory, vc.healthConditionCategory, vc.visitCategory
FROM RegistrationCards rc
LEFT JOIN Hospitals h ON rc.idHospital=h.idHospital
LEFT JOIN Visitors v ON rc.idVisitor=v.idVisitor
LEFT JOIN VisitorAgeGroupCategories vagc ON rc.idVisitorAgeGroupCategory=vagc.idVisitorAgeGroupCategory
LEFT JOIN VisitorCategories vc ON rc.idVisitorCategory=vc.idVisitorCategory
ORDER BY rc.idRegistrationCard;

SELECT * FROM WorkShifts;
SELECT * FROM WorkerContracts;
SELECT * FROM WorkPositions;
SELECT * FROM WorkExperience ORDER BY salaryIndex ASC;
SELECT * FROM Specialities;
SELECT * FROM Cars;
SELECT * FROM DriverLicenses;

SELECT wc.idNumberOfContract, h.hospitalName, wc.dateOfSigning FROM WorkerContracts wc
LEFT JOIN Hospitals h ON wc.idHospital=h.idHospital;
SELECT * FROM Doctors;

SELECT * FROM Nurses;
SELECT d.doctorName, d.doctorSurname, n.nurseName, n.nurseSurname, dr.driverName, dr.driverSurname, c.idNumberOfContract
FROM WorkerContracts c
LEFT JOIN Doctors d ON c.idNumberOfContract=d.idNumberOfContract
LEFT JOIN Nurses n ON c.idNumberOfContract=n.idNumberOfContract
LEFT JOIN Drivers dr ON c.idNumberOfContract=dr.idNumberOfContract;

SELECT doc.doctorName, doc.doctorSurname, n.nurseName, n.nurseSurname, dr.driverName, dr.driverSurname, ex.idWorkExp
FROM WorkExperience ex
LEFT JOIN Doctors doc ON ex.idWorkExp=doc.idWorkExp
LEFT JOIN Nurses n ON ex.idWorkExp=n.idWorkExp
LEFT JOIN Drivers dr ON ex.idWorkExp=dr.idWorkExp
WHERE ex.idWorkExp<4 AND ex.idWorkExp>1;

SELECT idHospital, COUNT(idVisitor) FROM RegistrationCards
GROUP BY idHospital;

SELECT dl.idDriver, c.carModel FROM DriverLicenses dl
INNER JOIN Cars c ON dl.idCar=c.idCar;

SELECT h.hospitalName, regc.idVisitor, wc.idNumberOfContract FROM Hospitals h
LEFT JOIN RegistrationCards regc ON h.idHospital=regc.idHospital
LEFT JOIN WorkerContracts wc ON h.idHospital=wc.idHospital;

SELECT idHospital, hospitalName FROM Hospitals;
DELETE FROM Hospitals
WHERE idHospital = 7;

SELECT * FROM Visitors WHERE idVisitor = 1;
SELECT * FROM Cars WHERE idCarFleet = 3;
SELECT idCar, carBrandName, carModel, carRegNumber, idCarFleet FROM Cars WHERE idCar = 2;
SELECT * FROM Cars;
INSERT INTO Cars(carBrandName, carModel, carRegNumber, idCarFleet) VALUES ("BMW", "X6", "7777OC-7", 3);
SELECT idCar FROM Cars WHERE carBrandName = 'BMW';
DELETE FROM Cars WHERE idCar IN (SELECT idCar FROM Cars WHERE carBrandName = 'BMW');
SELECT * FROM Cars;
drop database HospitalsDB;
DELETE FROM Cars WHERE idCar = 100;
DELETE FROM Cars WHERE carBrandName = 'TestCar' LIMIT 1;
UPDATE Cars SET carBrandName = 'TestCar2ndEdit', carModel = 'Testing', carRegNumber = 'Testing', idCarFleet = 2 WHERE idCar = 100;
delete from RegistrationCards where idRegistrationCard = 99;
delete from Visitors where idVisitor = 99 limit 1;