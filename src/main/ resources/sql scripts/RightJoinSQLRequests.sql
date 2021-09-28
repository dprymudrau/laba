SELECT idTicket,passengerId,placeNumber, dateOfBuying, flightDate, price
FROM Ticket RIGHT JOIN Flight 
ON idTicket=idFlight
WHERE price>1000;

SELECT pilotName,serialNumber, planeModelName
FROM Plane RIGHT JOIN Pilot ON Pilot.companyId = Plane.companyId 
RIGHT JOIN PlaneModel ON modelId = idPlaneModel;

SELECT *
FROM Passenger RIGHT JOIN (SELECT idFlight, passengerId, flightCategoryName
							FROM Ticket LEFT JOIN Flight ON idFlight = flightId 
                            LEFT JOIN FlightCategory ON categoryId = idFlightCategory
                            WHERE flightCategoryName ="VIP") 
AS X ON idPassenger = passengerId;

SELECT *
FROM Ticket 
RIGHT JOIN Flight ON idTicket=idFlight
RIGHT JOIN Passenger ON idPassenger = passengerId;

SELECT idTicket,passengerName,placeNumber, dateOfBuying
FROM Ticket RIGHT JOIN Passenger ON idPassenger = passengerId
WHERE passengerName = 'Ochen';

SELECT * 
FROM FlightWay 
RIGHT JOIN (SELECT idAirport,airportName, townName, countryName 
			FROM Airport 
			LEFT JOIN Town ON townId = idTown
			LEFT JOIN Country ON countryId = idCountry
            WHERE countryName = "Belarusian") 
AS A ON whereAirportId = idAirport;

SELECT idFlight, price, flightDate
FROM FlightCategory RIGHT JOIN Flight ON categoryId = idFlightCategory
WHERE flightCategoryName !="Econom" AND price <2000;

SELECT idFlight, price
FROM Flight RIGHT JOIN FlightCategory ON categoryId = idFlightCategory
WHERE flightCategoryName ="Econom";

SELECT * FROM Passenger right join PassengerAccount ON idPassengerAccount = accountId;

SELECT airportName, townName, countryName 
FROM Airport 
RIGHT JOIN Town ON townId = idTown
RIGHT JOIN Country ON countryId = idCountry;