USE airporttickets;

DELETE FROM Flight
WHERE price<1000 and price>500;

SELECT * FROM Flight;

DELETE FROM Passenger
WHERE passengerName ='Ochen';

SELECT * FROM Passenger;

DELETE FROM pilot
WHERE pilotCategoryId<1;

SELECT * FROM pilot;

DELETE FROM plane
WHERE companyId>2;

SELECT * FROM plane;

DELETE FROM passenger
WHERE accountId = (SELECT idPassengerAccount FROM passengeraccount WHERE fullName = 'Zlotov Danylo Nemaksymovich');

SELECT * FROM passenger;

DELETE FROM company 
WHERE companyDescription = null;

SELECT * FROM company;

DELETE FROM ticket 
WHERE dateOfBuying = '2039-01-19 03:14:07';

SELECT * FROM ticket;

DELETE FROM airport 
WHERE passengersPerDay>1000;

SELECT * FROM airport;

DELETE FROM ticket;

SELECT * FROM ticket;

DELETE FROM planemodel
WHERE capacity<90;

SELECT * FROM planemodel;
