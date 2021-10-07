USE airporttickets;

UPDATE company SET companyDescription = NULL;

UPDATE flight SET price = price + 1000 where price<1000;

UPDATE passenger SET passengerName = "Dan" WHERE passengerName = 'Danylo';

UPDATE planemodel SET capacity = 200 WHERE planeModelName = 'S-323';

UPDATE airport SET townId = 2 WHERE airportName = 'Boryspil';

UPDATE ticket SET ticket.placeNumber = 50 WHERE ticket.idTicket=2;

update pilotcategory SET pilotcategory.pilotCategoryName = 'New pilot' WHERE pilotcategory.idPilotCategory=1;

update pilot SET pilot.companyId =1 WHERE pilot.pilotName = 'Pavel';

update plane SET plane.serialNumber = '77777777' WHERE plane.serialNumber='S-323';

