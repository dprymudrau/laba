INSERT PassengerAccount(passportNumber,fullName) 
VALUES ("1234567890", "Zlotov Danylo Nemaksymovich"),
("0987654321","Votolz Olynad Hcivomyskamen"),
("5647382910", "Kto-to Ochen Vajnyi");

INSERT Passenger(accountId,passengerName,phoneNumber)
VALUES (1, "Danylo","0938228305"),
(2, "Olynad", "0934552323"),
(3, "Ochen", "0937459805");

INSERT FlightCategory(flightCategoryName)
VALUES ("Econom"), ("Business"), ("VIP");

INSERT PlaneModel(capacity, planeModelName)
VALUES (80, "A-202"), (100, "D-180"), (300,"S-323");

INSERT Country(countryName)
VALUES ("Ukraine"),("Belarusian"),("Poland");

INSERT Town(countryId,townName)
VALUES (1, "Kyiv"), (2, "Minsk"), (3, "Warszawa");

INSERT Airport(townId,airportName,passengersPerDay)
VALUES (1, "Boryspil", 1000), (2, "Belarussian Airport", 700), (3, "Poland Airport", 2000);

INSERT Company(companyName,companyDescription)
VALUES ("Ukrainian Airlines", "Shche ne vmerla"), ("Belarussian Airlines", "No comments"), ("Pshce Airlines", null);

INSERT FlightWay(fromAirportId,whereAirportId,companyId)
VALUES (1, 2, 1),(2, 3, 3),(3, 2, 2);

INSERT Plane(companyId,modelId,serialNumber)
VALUES (1, 1, "00103020"), (2, 3, "11030201"),(3, 2, "84920100");

INSERT Plane(companyId,modelId,serialNumber)
VALUES (1, 1, "00103021");

INSERT PilotCategory(pilotCategoryName)
VALUES ("Newbie"), ("Master"), ("Bird");

INSERT Pilot(companyId,pilotCategoryId,pilotName,workExperience)
VALUES (1, 2, "Pavlo", 5), (2, 1, "Pavel", 2), (3, 3, "Pshcevel", 15), (1, 1, "Ne Pavlo", 3);

INSERT Pilot(companyId,pilotCategoryId,pilotName,workExperience)
VALUES (1, 1, "Ne Pavlo", 3);

INSERT Flight(pilotId,planeId,flightWayId,categoryId,price,flightDate)
VALUES (1, 1, 1, 2, 1000, '2038-01-20 03:14:07'), 
(2, 2, 3, 1, 300, '2038-01-19 03:14:07'),
(3, 3, 2, 3, 20000, '2038-04-19 03:14:07');

INSERT Ticket(passengerId, flightId, placeNumber, dateOfBuying)
VALUES (1, 1, 43, '2039-01-19 03:14:07'),
(2, 3, 55, '2038-07-19 03:14:07'), 
(3, 1, 59, '2038-06-21 03:14:07');