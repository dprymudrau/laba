SELECT idTicket,passengerId,placeNumber, dateOfBuying, flightDate, price
FROM Ticket INNER JOIN Flight 
ON idTicket=idFlight
WHERE price>1000;

SELECT idTicket,passengerName,placeNumber, dateOfBuying, flightDate, price
FROM Ticket 
INNER JOIN Flight ON idTicket=idFlight
INNER JOIN Passenger ON idPassenger = passengerId
WHERE passengerName = 'Danylo';

SELECT * FROM Passenger INNER JOIN PassengerAccount ON idPassengerAccount = accountId;

SELECT airportName, townName, countryName 
FROM Airport 
INNER JOIN Town ON townId = idTown
INNER JOIN Country ON countryId = idCountry;

SELECT idFlightWay 
FROM FlightWay 
INNER JOIN (SELECT idAirport,airportName, townName, countryName 
			FROM Airport 
			LEFT JOIN Town ON townId = idTown
			LEFT JOIN Country ON countryId = idCountry) 
AS A ON whereAirportId = idAirport
WHERE countryName = "Belarusian";

SELECT idFlight, price
FROM Flight 
INNER JOIN Pilot ON pilotId = idPilot
INNER JOIN PilotCategory ON categoryId = idPilotCategory
WHERE pilotCategoryName != "Newbie";

SELECT pilotName, serialNumber, planeModelName
FROM Pilot INNER JOIN Plane ON Pilot.companyId = Plane.companyId 
INNER JOIN PlaneModel ON modelId = idPlaneModel
WHERE Pilot.companyId = 1;

SELECT idFlight, price
FROM Flight INNER JOIN FlightCategory ON categoryId = idFlightCategory
WHERE flightCategoryName !="Econom";

SELECT idFlight, price
FROM Flight INNER JOIN FlightCategory ON categoryId = idFlightCategory
WHERE flightCategoryName ="Econom";

SELECT *
FROM Passenger INNER JOIN (SELECT idFlight, passengerId, flightCategoryName
							FROM Ticket LEFT JOIN Flight ON idFlight = flightId 
                            LEFT JOIN FlightCategory ON categoryId = idFlightCategory
                            WHERE flightCategoryName ="VIP")
AS X ON idPassenger = passengerId;