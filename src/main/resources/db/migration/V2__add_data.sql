insert into car (free, name, id) values (true, 'AUDI', 1);
insert into car (free, name, id) values (true, 'MERS', 2);
insert into car (free, name, id) values (true, 'BMV', 3);
insert into car (free, name, id) values (true, 'TESLA', 4);

insert into user_table ( email, first_name, last_name, role, id) values ( 'max@max.max', 'Max', 'Naumovich', 2, 1);
insert into user_table ( email, first_name, last_name, role, id) values ( 'max2@max.max', 'Max', 'Naumovich', 2, 2);

insert into user_credentials (active, creation_date, password, id) values ('true', '2021-01-26 20:25:31.198', 'max', 1);
insert into user_credentials (active, creation_date, password, id) values ('true', '2021-01-26 20:25:31.198', 'max', 2);


insert into user_table_credentials (u1, u2) values (1, 1);
insert into user_table_credentials (u1, u2) values (2, 2);

ALTER SEQUENCE hibernate_sequence RESTART WITH 5;