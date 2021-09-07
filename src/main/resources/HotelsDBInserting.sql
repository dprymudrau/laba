USE HospitalsDB;

INSERT INTO CarFleets(capacityByCars)
VALUES
(8),
(42),
(3);

INSERT INTO Hospitals(hospitalName, hospitalAddress, idCarFleet)
VALUES
('Municipal Gynecological Hospital', 'Minsk, Sennitskaya 53', 1),
('Ambulance Hospital', 'Minsk, Kizhevatova 58', 2),
('Center of Surgery and Transplantology', 'Semashko 8', 3),
('Municipal Clinical Hospital Savchenko', 'Minsk, Roza Luksenburg 110', 1);

INSERT INTO Visitors(visitorName, visitorSurname, visitorAddress, diagnosis, visitDate, dischargeDate)
VALUES
('Vasya', 'Pupkin', 'Minsk, Nezavisimosti 8', 'Alcoholism', '2021-09-03', '0000-00-00'),
('Alexey', 'Puplikov', 'Minsk, Grushevka', 'Wickness', '2020-01-01', '2020-01-05'),
('Alexandr', 'Lukash', 'Minsk, Drozdi 12', 'Manic schizophrenia due to alcoholism', '1994-06-20', '0000-00-00');

INSERT INTO VisitorCategories(healthConditionCategory, visitCategory)
VALUES
('Healthy', 'Prophylactic examination'),
('Healthy', 'After recovery'),
('Sick', 'Initial inspection'),
('Sick', 'Secondary inspection'),
('Seriously ill', 'Initial inspection'),
('Seriously ill', 'Secondary inspection');
