INSERT INTO organization (name, full_name, inn, kpp, address, phone_number, is_active)
VALUES
 ('VTB', 'Vneshtorgbank', '7702070139', '667102001',
 '125009, г. Москва, ул. Тверская, 22', '88001002424', true),
 ('Sberbank', ' PJSC Sberbank', '7707083893', '773601001',
 'г. Саратов, ул. Лермонтова, д. 28а', '88005555550', true),
 ('Tinkoff Bank', 'Tinkoff Credit Systems', '7710140679', '773401001',
 '123060, г. Москва, 1-й Волоколамский проезд, д. 10, стр. 1', '88005557778', true);

INSERT INTO office (organization_id, name, address, phone_number, is_active)
VALUES
 (1, 'Филиал № 7701 Банка ВТБ', 'г. Москва, ул. Кузнецкий Мост, д. 17', '89008007656', true),
 (2, 'Доп.офис № 9038/0524', '125009, г. Москва, ул. Тверская, 22', '87008009767', true),
 (3, 'Головной офис', '123060, г. Москва, 1-й Волоколамский проезд, д. 10, стр. 1',
 '88005557778', true);

INSERT INTO document_type (name, code)
VALUES
 ('Паспорт гражданина РФ', '21'),
 ('Свидетельство о рождении', '03'),
 ('Вид на жительство в Российской Федерации', '12');

INSERT INTO document (number, date, document_type_id)
VALUES
 ('666053', '2011-04-04', 1),
 ('627812', '1991-01-15', 2),
 ('006074', '2001-02-12', 3);

INSERT INTO citizenship (name, code)
VALUES
 ('Российская Федерация', '643'),
 ('Государство Израиль', '376'),
 ('Республика Беларусь', '112');

INSERT INTO user (office_id, first_name, second_name, middle_name,
position, phone_number, document_id, citizenship_id, is_identified)
VALUES
 (1, 'Jack', 'Hooker', 'Black', 'Manager', '88764837733', 1, 1, true),
 (2, 'Ivan', 'Brozov', 'Ivanovich', 'Scrum master', '84525602233', 2, 2, true),
 (3, 'Kate', 'Digner', 'Sky', 'Human resources', '86788887765', 3, 3, true);