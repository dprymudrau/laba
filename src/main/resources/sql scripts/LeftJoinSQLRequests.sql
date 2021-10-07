SELECT idTicket,passengerId,placeNumber, dateOfBuying, flightDate, price
FROM Ticket LEFT JOIN Flight 
ON idTicket=idFlight
WHERE price>1000;

SELECT idTicket,passengerName,placeNumber, dateOfBuying, flightDate, price
FROM Ticket 
LEFT JOIN Flight ON idTicket=idFlight
LEFT JOIN Passenger ON idPassenger = passengerId
WHERE passengerName = 'Danylo';

SELECT * FROM Passenger left join PassengerAccount ON idPassengerAccount = accountId;

SELECT airportName, townName, countryName 
FROM Airport 
LEFT JOIN Town ON townId = idTown
LEFT JOIN Country ON countryId = idCountry;

SELECT idFlightWay 
FROM FlightWay 
LEFT JOIN (SELECT idAirport,airportName, townName, countryName 
			FROM Airport 
			LEFT JOIN Town ON townId = idTown
			LEFT JOIN Country ON countryId = idCountry) 
AS A ON whereAirportId = idAirport
WHERE countryName = "Belarusian";

SELECT idFlight, price
FROM Flight 
LEFT JOIN Pilot ON pilotId = idPilot
LEFT JOIN PilotCategory ON categoryId = idPilotCategory
WHERE pilotCategoryName != "Newbie";

SELECT pilotName, serialNumber, planeModelName
FROM Pilot LEFT JOIN Plane ON Pilot.companyId = Plane.companyId 
LEFT JOIN PlaneModel ON modelId = idPlaneModel
WHERE Pilot.companyId = 1;

SELECT idFlight, price
FROM Flight LEFT JOIN FlightCategory ON categoryId = idFlightCategory
WHERE flightCategoryName !="Econom";

SELECT idFlight, price
FROM Flight LEFT JOIN FlightCategory ON categoryId = idFlightCategory
WHERE flightCategoryName ="Econom";

SELECT *
FROM Passenger LEFT JOIN (SELECT idFlight, passengerId, flightCategoryName
							FROM Ticket LEFT JOIN Flight ON idFlight = flightId 
                            LEFT JOIN FlightCategory ON categoryId = idFlightCategory
                            WHERE flightCategoryName ="VIP")
AS X ON idPassenger = passengerId;