INSERT INTO address (id, name)
VALUES
(1, '125009, г. Москва, ул. Тверская, 22'),
(2, 'г. Саратов, ул. Лермонтова, д. 28а'),
(3, '123060, г. Москва, 1-й Волоколамский проезд, д. 10, стр. 1');

INSERT INTO phone (id, number)
VALUES
(1, '88001002424'),
(2, '88005555550'),
(3, '88005557778'),
(4, '88764837733'),
(5, '84525602233'),
(6, '86788887765');

INSERT INTO organization_info (id, name, full_name, inn, kpp, phone_id)
VALUES
(1, 'VTB', 'Vneshtorgbank', 7702070139, 667102001, 1),
(2, 'Sberbank', ' PJSC Sberbank', 7707083893, 773601001, 2),
(3, 'Tinkoff Bank', 'Tinkoff Credit Systems', 7710140679, 773401001, 3);

INSERT INTO organization (id, organization_info_id, address_id, is_active)
VALUES
(1, 1, 1, true),
(2, 2, 2, true),
(3, 3, 3, true);

INSERT INTO office (id, organization_id, name, address_id, phone_id, is_active)
VALUES
(1, 1, 'Филиал № 7701 Банка ВТБ', 1, 1, true),
(2, 2, 'Доп.офис № 9038/0524', 2, 2, true),
(3, 3, 'Головной офис', 3, 3, true);


INSERT INTO user_info (id, first_name, second_name, middle_name, position, phone_id)
VALUES
 (1, 'Jack', 'Hooker', 'Black', 'Manager', 4),
 (2, 'Ivan', 'Brozov', 'Ivanovich', 'Scrum master', 5),
 (3, 'Kate', 'Digner', 'Sky', 'Human resources', 6);

INSERT INTO document (id, name, code, number, date)
VALUES
 (1, 'Паспорт гражданина РФ', '21', '666053', '2011-04-04'),
 (2, 'Свидетельство о рождении', '03', '627812', '1991-01-15'),
 (3, 'Вид на жительство в Российской Федерации', '12', '006074', '2001-02-12');

INSERT INTO citizenship (id, name, code)
VALUES
 (1, 'Российская Федерация', '643'),
 (2, 'Государство Израиль', '376'),
 (3, 'Республика Беларусь', '112');

INSERT INTO user (id, office_id, user_info_id, document_id, citizenship_id, is_identified)
VALUES
 (1, 1, 1, 1, 1, true),
 (2, 2, 2, 2, 2, true),
 (3, 3, 3, 3, 3, true);