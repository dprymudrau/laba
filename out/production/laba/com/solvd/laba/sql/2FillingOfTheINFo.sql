create database ITCompany;
use ItCompany;

-- Filling of the info

INSERT INTO DepartmentName (name) VALUES
('Finance'),
('Supply'),
('Analytics'),
('Development'),
('Support');

-- create table Order

INSERT INTO Tasks (task) VALUES
('Task1'),
('Task2'),
('Task3'),
('Task4'),
('Task5');

INSERT INTO TasksStatus (tasksStatus) VALUES
('Pending'),
('During'),
('Completed');

INSERT INTO TasksLevel (tasksLevel) VALUES
('LowPriority'),
('MediumPriority'),
('HighPriority');

INSERT INTO ITCompanies (companyName) VALUES
('Company1'),
('Company2'),
('Company3'),
('Company4'),
('Company5');

INSERT INTO ITCompanyContact (iTCCName, iTCCSurname, iTCCPatronymic) VALUES
('Name1','Surname1','Patronymic1'),
('Name2','Surname2','Patronymic2'),
('Name3','Surname3','Patronymic3'),
('Name4','Surname4','Patronymic4'),
('Name5','Surname5','Patronymic5');


INSERT INTO Custumer (companyName) VALUES
('Company1'),
('Company2'),
('Company3'),
('Company4'),
('Company5');

INSERT INTO СustomerСontact  (cCName, cCSurname, cCPatronymic) VALUES
('Name1','Surname1','Patronymic1'),
('Name2','Surname2','Patronymic2'),
('Name3','Surname3','Patronymic3'),
('Name4','Surname4','Patronymic4'),
('Name5','Surname5','Patronymic5');

INSERT INTO Emails (emailAdress) VALUES
('Mail1@gmail.com'),
('Mail1@gmai2.com'),
('Mail1@gmai3.com'),
('Mail1@gmai4.com'),
('Mail1@gmai5.com');

INSERT INTO City (cityName, codeNumber) VALUES
('CityNamel','001'),
('CityName2','002'),
('CityName3','003'),
('CityName4','004'),
('CityName5','005');

INSERT INTO PhoneNumbers (phoneNumberscol) VALUES
('001'),
('002'),
('003'),
('004'),
('005');

INSERT INTO Adress (adress) VALUES
('Adress1'),
('Adress2'),
('Adress3'),
('Adress4'),
('Adress5');

-- create table MainOfiseAdress

-- create table City_has_ITCompany

INSERT INTO Positione (positione) VALUES
('trainee'),
('intern'),
('midle'),
('senior'),
('teamLead');


INSERT INTO Emploee  (cCName, cCSurname, cCPatronymic) VALUES
('Name1','Surname1','Patronymic1'),
('Name2','Surname2','Patronymic2'),
('Name3','Surname3','Patronymic3'),
('Name4','Surname4','Patronymic4'),
('Name1','Surname5','Patronymic5');


