-- 10: DELETE, UPDATE, LEFT Join, RIGHT Join, INNER Join

DELETE FROM Emploee WHERE cCName = 'Name1';
DELETE FROM Tasks WHERE id = 1;
DELETE FROM ITCompanys WHERE companyName = 'Company4';
DELETE FROM ITCompanyContact WHERE iTCCSurname = 'Patronymic4';
DELETE FROM ITCompanyContact WHERE iTCCName <> 'Name1';
DELETE FROM Emails WHERE emailAdress = 'Mail3@gmail.com';
DELETE FROM City WHERE cityName = 'CityName3';
DELETE FROM City WHERE codeNumber = '005';
DELETE FROM PhoneNumbers WHERE phoneNumberscol = '001';
DELETE FROM Adress WHERE adress = 'Adress1';

UPDATE Emploee SET cCName = 'Name1';
UPDATE ITCompanys SET companyName = 'Company4';
UPDATE ITCompanys SET iTCCSurname = 'Surname4';
UPDATE ITCompanyContact SET iTCCSurname = 'Patronymic4';
UPDATE Emails SET emailAdress = 'Mail3@gmail.com';
UPDATE City SET cityName = 'CityName3';
UPDATE City SET codeNumber = '005';
UPDATE PhoneNumbers SET phoneNumberscol = '001';
UPDATE Adress SET adress = 'Adress1';
UPDATE Emploee SET cCPatronymic = 'Patronymic6';

SELECT Emploee.cCName as eName, Emploee.cCSurname as eSurN, Emploee.cCPatronymic as ePatr, Emploee.departmentTypeId as eDep,
DepartmentName.name as dName, DepartmentName.id as dID
FROM Emploee
LEFT JOIN Emploee on DepartmentName.id = Emploee.departmentTypeId WHERE dName = 'Finance';

SELECT Emploee.cCName as eName, Emploee.cCSurname as eSurN, Emploee.cCPatronymic as ePatr, Emploee.departmentTypeId as eDep,
DepartmentName.name as dName, DepartmentName.id as dID
FROM Emploee
LEFT JOIN Emploee on DepartmentName.id = Emploee.departmentTypeId WHERE dName = 'Supply';

SELECT Emploee.cCName as eName, Emploee.cCSurname as eSurN, Emploee.cCPatronymic as ePatr, Emploee.departmentTypeId as eDep,
DepartmentName.name as dName, DepartmentName.id as dID
FROM Emploee
LEFT JOIN Emploee on DepartmentName.id = Emploee.departmentTypeId WHERE dName = 'Analytics';

SELECT Emploee.cCName as eName, Emploee.cCSurname as eSurN, Emploee.cCPatronymic as ePatr, Emploee.departmentTypeId as eDep,
DepartmentName.name as dName, DepartmentName.id as dID
FROM Emploee
LEFT JOIN Emploee on DepartmentName.id = Emploee.departmentTypeId WHERE dName = 'Development';

SELECT Emploee.cCName as eName, Emploee.cCSurname as eSurN, Emploee.cCPatronymic as ePatr, Emploee.departmentTypeId as eDep,
DepartmentName.name as dName, DepartmentName.id as dID
FROM Emploee
LEFT JOIN Emploee on DepartmentName.id = Emploee.departmentTypeId WHERE dName = 'Support';

SELECT ITCompanyContact.iTCCName as contName , ITCompanyContact.iTCCSurname as contSutname, ITCompanyContact.iTCCPatronymic as contPatron,
СustomerСontact.cCName as custName, СustomerСontact.cCSurname as custSurname,  СustomerСontact.cCPatronymic as custPatron
FROM СustomerСontact
LEFT JOIN ITCompanyContact on contName = custName;

SELECT ITCompanyContact.iTCCName as contName , ITCompanyContact.iTCCSurname as contSutname, ITCompanyContact.iTCCPatronymic as contPatron,
СustomerСontact.cCName as custName, СustomerСontact.cCSurname as custSurname,  СustomerСontact.cCPatronymic as custPatron
FROM СustomerСontact
LEFT JOIN ITCompanyContact on contSutname = custSurname;

SELECT ITCompanyContact.iTCCName as contName , ITCompanyContact.iTCCSurname as contSutname, ITCompanyContact.iTCCPatronymic as contPatron,
СustomerСontact.cCName as custName, СustomerСontact.cCSurname as custSurname,  СustomerСontact.cCPatronymic as custPatron
FROM СustomerСontact
LEFT JOIN ITCompanyContact on contPatron = custPatron;

SELECT ITCompanyContact.iTCCName as contName , ITCompanyContact.iTCCSurname as contSutname, ITCompanyContact.iTCCPatronymic as contPatron,
СustomerСontact.cCName as custName, СustomerСontact.cCSurname as custSurname,  СustomerСontact.cCPatronymic as custPatron
FROM СustomerСontact
LEFT JOIN ITCompanyContact on contName = custSurname ;

SELECT ITCompanyContact.iTCCName as contName , ITCompanyContact.iTCCSurname as contSutname, ITCompanyContact.iTCCPatronymic as contPatron,
СustomerСontact.cCName as custName, СustomerСontact.cCSurname as custSurname,  СustomerСontact.cCPatronymic as custPatron
FROM СustomerСontact
LEFT JOIN ITCompanyContact on contPatron = custSurname;



SELECT Emploee.cCName as eName, Emploee.cCSurname as eSurN, Emploee.cCPatronymic as ePatr, Emploee.departmentTypeId as eDep,
DepartmentName.name as dName, DepartmentName.id as dID
FROM Emploee
RIGHT JOIN Emploee on DepartmentName.id = Emploee.departmentTypeId WHERE dName = 'Finance';

SELECT Emploee.cCName as eName, Emploee.cCSurname as eSurN, Emploee.cCPatronymic as ePatr, Emploee.departmentTypeId as eDep,
DepartmentName.name as dName, DepartmentName.id as dID
FROM Emploee
RIGHT JOIN Emploee on DepartmentName.id = Emploee.departmentTypeId WHERE dName = 'Supply';

SELECT Emploee.cCName as eName, Emploee.cCSurname as eSurN, Emploee.cCPatronymic as ePatr, Emploee.departmentTypeId as eDep,
DepartmentName.name as dName, DepartmentName.id as dID
FROM Emploee
RIGHT JOIN Emploee on DepartmentName.id = Emploee.departmentTypeId WHERE dName = 'Analytics';

SELECT Emploee.cCName as eName, Emploee.cCSurname as eSurN, Emploee.cCPatronymic as ePatr, Emploee.departmentTypeId as eDep,
DepartmentName.name as dName, DepartmentName.id as dID
FROM Emploee
RIGHT JOIN Emploee on DepartmentName.id = Emploee.departmentTypeId WHERE dName = 'Development';

SELECT Emploee.cCName as eName, Emploee.cCSurname as eSurN, Emploee.cCPatronymic as ePatr, Emploee.departmentTypeId as eDep,
DepartmentName.name as dName, DepartmentName.id as dID
FROM Emploee
RIGHT JOIN Emploee on DepartmentName.id = Emploee.departmentTypeId WHERE dName = 'Support';

SELECT ITCompanyContact.iTCCName as contName , ITCompanyContact.iTCCSurname as contSutname, ITCompanyContact.iTCCPatronymic as contPatron,
СustomerСontact.cCName as custName, СustomerСontact.cCSurname as custSurname,  СustomerСontact.cCPatronymic as custPatron
FROM СustomerСontact
RIGHT JOIN ITCompanyContact on contName = custName;

SELECT ITCompanyContact.iTCCName as contName , ITCompanyContact.iTCCSurname as contSutname, ITCompanyContact.iTCCPatronymic as contPatron,
СustomerСontact.cCName as custName, СustomerСontact.cCSurname as custSurname,  СustomerСontact.cCPatronymic as custPatron
FROM СustomerСontact
RIGHT JOIN ITCompanyContact on contSutname = custSurname;

SELECT ITCompanyContact.iTCCName as contName , ITCompanyContact.iTCCSurname as contSutname, ITCompanyContact.iTCCPatronymic as contPatron,
СustomerСontact.cCName as custName, СustomerСontact.cCSurname as custSurname,  СustomerСontact.cCPatronymic as custPatron
FROM СustomerСontact
RIGHT JOIN ITCompanyContact on contPatron = custPatron;

SELECT ITCompanyContact.iTCCName as contName , ITCompanyContact.iTCCSurname as contSutname, ITCompanyContact.iTCCPatronymic as contPatron,
СustomerСontact.cCName as custName, СustomerСontact.cCSurname as custSurname,  СustomerСontact.cCPatronymic as custPatron
FROM СustomerСontact
RIGHT JOIN ITCompanyContact on contName = custSurname ;

SELECT ITCompanyContact.iTCCName as contName , ITCompanyContact.iTCCSurname as contSutname, ITCompanyContact.iTCCPatronymic as contPatron,
СustomerСontact.cCName as custName, СustomerСontact.cCSurname as custSurname,  СustomerСontact.cCPatronymic as custPatron
FROM СustomerСontact
RIGHT JOIN ITCompanyContact on contPatron = custSurname;


SELECT Emploee.cCName as eName, Emploee.cCSurname as eSurN, Emploee.cCPatronymic as ePatr, Emploee.departmentTypeId as eDep,
DepartmentName.name as dName, DepartmentName.id as dID
FROM Emploee
INNER JOIN Emploee on DepartmentName.id = Emploee.departmentTypeId WHERE dName = 'Finance';

SELECT Emploee.cCName as eName, Emploee.cCSurname as eSurN, Emploee.cCPatronymic as ePatr, Emploee.departmentTypeId as eDep,
DepartmentName.name as dName, DepartmentName.id as dID
FROM Emploee
INNER JOIN Emploee on DepartmentName.id = Emploee.departmentTypeId WHERE dName = 'Supply';

SELECT Emploee.cCName as eName, Emploee.cCSurname as eSurN, Emploee.cCPatronymic as ePatr, Emploee.departmentTypeId as eDep,
DepartmentName.name as dName, DepartmentName.id as dID
FROM Emploee
INNER JOIN Emploee on DepartmentName.id = Emploee.departmentTypeId WHERE dName = 'Analytics';

SELECT Emploee.cCName as eName, Emploee.cCSurname as eSurN, Emploee.cCPatronymic as ePatr, Emploee.departmentTypeId as eDep,
DepartmentName.name as dName, DepartmentName.id as dID
FROM Emploee
INNER JOIN Emploee on DepartmentName.id = Emploee.departmentTypeId WHERE dName = 'Development';

SELECT Emploee.cCName as eName, Emploee.cCSurname as eSurN, Emploee.cCPatronymic as ePatr, Emploee.departmentTypeId as eDep,
DepartmentName.name as dName, DepartmentName.id as dID
FROM Emploee
INNER JOIN Emploee on DepartmentName.id = Emploee.departmentTypeId WHERE dName = 'Support';

SELECT ITCompanyContact.iTCCName as contName , ITCompanyContact.iTCCSurname as contSutname, ITCompanyContact.iTCCPatronymic as contPatron,
СustomerСontact.cCName as custName, СustomerСontact.cCSurname as custSurname,  СustomerСontact.cCPatronymic as custPatron
FROM СustomerСontact
INNER JOIN ITCompanyContact on contName = custName;

SELECT ITCompanyContact.iTCCName as contName , ITCompanyContact.iTCCSurname as contSutname, ITCompanyContact.iTCCPatronymic as contPatron,
СustomerСontact.cCName as custName, СustomerСontact.cCSurname as custSurname,  СustomerСontact.cCPatronymic as custPatron
FROM СustomerСontact
INNER JOIN ITCompanyContact on contSutname = custSurname;

SELECT ITCompanyContact.iTCCName as contName , ITCompanyContact.iTCCSurname as contSutname, ITCompanyContact.iTCCPatronymic as contPatron,
СustomerСontact.cCName as custName, СustomerСontact.cCSurname as custSurname,  СustomerСontact.cCPatronymic as custPatron
FROM СustomerСontact
INNER JOIN ITCompanyContact on contPatron = custPatron;

SELECT ITCompanyContact.iTCCName as contName , ITCompanyContact.iTCCSurname as contSutname, ITCompanyContact.iTCCPatronymic as contPatron,
СustomerСontact.cCName as custName, СustomerСontact.cCSurname as custSurname,  СustomerСontact.cCPatronymic as custPatron
FROM СustomerСontact
INNER JOIN ITCompanyContact on contName = custSurname ;

SELECT ITCompanyContact.iTCCName as contName , ITCompanyContact.iTCCSurname as contSutname, ITCompanyContact.iTCCPatronymic as contPatron,
СustomerСontact.cCName as custName, СustomerСontact.cCSurname as custSurname,  СustomerСontact.cCPatronymic as custPatron
FROM СustomerСontact
INNER JOIN ITCompanyContact on contPatron = custSurname;





