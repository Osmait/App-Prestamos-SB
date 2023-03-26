--
insert into users (id, name, last_name, email, password) values (1, 'saul', 'burgos', 'saulburgos6@gmail.com', '$2a$10$e9v8.WXi1z8KuMgBjWv20OBpfhAcbPcOKuabwNjF2zOvDkFpOTRx2');
insert into users (id, name, last_name, email, password) values (2, 'Ignaz', 'Lynskey', 'ilynskey0@ca.gov', '5RquYc');
insert into users (id, name, last_name, email, password) values (3, 'Briggs', 'Fareweather', 'bfareweather2@scribd.com', '8HL4NMB');
-- $2a$10$e9v8.WXi1z8KuMgBjWv20OBpfhAcbPcOKuabwNjF2zOvDkFpOTRx2
-- Clients

insert into clients (id, name, last_name, email, phone_number, user_id) values (1, 'Berky', 'Cusick', 'bcusick0@biglobe.ne.jp', '330-495-6272', 1);
insert into clients (id, name, last_name, email, phone_number, user_id) values (2, 'Steffane', 'Faire', 'sfaire1@goo.ne.jp', '330-495-6272', 1);
insert into clients (id, name, last_name, email, phone_number, user_id) values (3, 'Vic', 'Checcuzzi', 'vcheccuzzi2@plala.or.jp', '330-495-6272', 1);
insert into clients (id, name, last_name, email, phone_number, user_id) values (4, 'Inglis', 'Doll', 'idoll3@angelfire.com', '330-495-6272', 3);
insert into clients (id, name, last_name, email, phone_number, user_id) values (5, 'Alisun', 'Mullin', 'amullin4@163.com', '330-495-6272', 2);


-- Loant

insert into loan (id, amount, client_id,create_at) values (1, 16493.90, 1,'2/6/2023');
insert into loan (id, amount, client_id,create_at) values (2, 2965.52, 1,'2/6/2023');
insert into loan (id, amount, client_id,create_at) values (3, 7823.36, 3,'2/6/2023');
insert into loan (id, amount, client_id,create_at) values (4, 15143.03, 4,'2/6/2023');
insert into loan (id, amount, client_id,create_at)values (5, 15878.89, 5,'2/6/2023');
insert into loan (id, amount, client_id,create_at) values (6, 6427.28, 2,'2/6/2023');
insert into loan (id, amount, client_id,create_at) values (7, 3752.73, 2,'2/6/2023');
insert into loan (id, amount, client_id,create_at) values (8, 13911.36, 2,'2/6/2023');
insert into loan (id, amount, client_id,create_at) values (9, 3458.93, 2,'2/6/2023');
insert into loan (id, amount, client_id,create_at) values (10, 8759.79, 3,'2/6/2023');


-- Transaction

insert into transaction (id, amount, loan_id,create_at) values (1, 757.81, 1,'2/6/2023');
insert into transaction (id, amount, loan_id,create_at) values (2, 694.98, 1,'6/6/2022');
insert into transaction (id, amount, loan_id,create_at) values (3, 229.33, 1,'6/6/2022');
insert into transaction (id, amount, loan_id,create_at) values (4, 132.63, 2,'6/6/2022');
insert into transaction (id, amount, loan_id,create_at) values (5, 831.51, 2,'12/8/2022');
insert into transaction (id, amount, loan_id,create_at) values (6, 603.90, 3,'12/8/2022');
insert into transaction (id, amount, loan_id,create_at) values (7, 835.14, 4,'12/8/2022');
insert into transaction (id, amount, loan_id,create_at) values (8, 614.74, 5,'12/8/2022');
insert into transaction (id, amount, loan_id,create_at) values (9, 639.98, 9,'12/8/2022');
insert into transaction (id, amount, loan_id,create_at) values (10, 364.82, 10,'12/8/2022');