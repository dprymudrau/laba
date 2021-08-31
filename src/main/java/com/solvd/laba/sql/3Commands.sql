-- 10: DELETE, UPDATE, LEFT, RIGHT, INNER

DELETE FROM Emploee WHERE cCName = 'Name1';
DELETE FROM Tasks WHERE id = 1;
DELETE FROM ITCompanys WHERE companyName = 'Company4';
DELETE FROM ITCompanyContact WHERE iTCCSurname = 'Patronymic4';
DELETE FROM ITCompanyContact WHERE iTCCName <> 'Name1';
DELETE FROM Emails WHERE emailAdress = 'Mail3@gmail.com';
DELETE FROM City WHERE cityName = 'CityName3';
DELETE FROM CityCode WHERE codeNumber = '005';
DELETE FROM PhoneNumbers WHERE phoneNumberscol = '001';
DELETE FROM Adress WHERE adress = 'Adress1';

UPDATE Emploee SET cCName = 'Name1';
UPDATE ITCompanys SET companyName = 'Company4';
UPDATE ITCompanys SET iTCCSurname = 'Surname4';
UPDATE ITCompanyContact SET iTCCSurname = 'Patronymic4';
UPDATE Emails SET emailAdress = 'Mail3@gmail.com';
UPDATE City SET cityName = 'CityName3';
UPDATE CityCode SET codeNumber = '005';
UPDATE PhoneNumbers SET phoneNumberscol = '001';
UPDATE Adress SET adress = 'Adress1';
UPDATE Emploee SET cCPatronymic = 'Patronymic6';
