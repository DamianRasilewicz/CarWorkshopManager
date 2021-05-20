INSERT INTO car_workshop_manager.workshops (city, street, number) VALUES ('Wroclaw', 'Wiejska', 3);
INSERT INTO car_workshop_manager.workshops (city, street, number) VALUES ('Warsaw', 'Warszatowa', 16);
INSERT INTO car_workshop_manager.workshops (city, street, number) VALUES ('Zielona Gora', 'Kluczowa', 6);
INSERT INTO car_workshop_manager.workshops (city, street, number) VALUES ('Poznań', 'Naprawialna', 12);

INSERT INTO car_workshop_manager.tasks (description, appro_execut_time, estimated_cost) VALUES ('front suspension replacement', 6, 600);
INSERT INTO car_workshop_manager.tasks (description, appro_execut_time, estimated_cost) VALUES ('rear suspension replacement', 4.5, 450);
INSERT INTO car_workshop_manager.tasks (description, appro_execut_time, estimated_cost) VALUES ('timing belt/chain replacement', 6, 600);
INSERT INTO car_workshop_manager.tasks (description, appro_execut_time, estimated_cost) VALUES ('tire change with balance', 1, 100);
INSERT INTO car_workshop_manager.tasks (description, appro_execut_time, estimated_cost) VALUES ('filters(oil,air,fuel,cabin) replacement', 2, 200);
INSERT INTO car_workshop_manager.tasks (description, appro_execut_time, estimated_cost) VALUES ('engine oil replacement', 0.5, 50);
INSERT INTO car_workshop_manager.tasks (description, appro_execut_time, estimated_cost) VALUES ('automatic transmission oil replacement', 4, 400);

INSERT INTO car_workshop_manager.mechanics (first_name, last_name, seniority, speciality, workshop_id)  VALUES ('Adam', 'Kowalski', 6, 'suspensions', 1);
INSERT INTO car_workshop_manager.mechanics (first_name, last_name, seniority, speciality, workshop_id)  VALUES ('Jan', 'Polak', 3, 'tires', 1);
INSERT INTO car_workshop_manager.mechanics (first_name, last_name, seniority, speciality, workshop_id)  VALUES ('Andrzej', 'Wit', 7, 'filters', 2);
INSERT INTO car_workshop_manager.mechanics (first_name, last_name, seniority, speciality, workshop_id)  VALUES ('Paweł', 'Czerniowki', 2, 'engines', 2);
INSERT INTO car_workshop_manager.mechanics (first_name, last_name, seniority, speciality, workshop_id)  VALUES ('Damian', 'Rosina', 5, 'electronics', 3);
INSERT INTO car_workshop_manager.mechanics (first_name, last_name, seniority, speciality, workshop_id)  VALUES ('Tomasz', 'Kwieciński', 6, 'varnishing', 3);
INSERT INTO car_workshop_manager.mechanics (first_name, last_name, seniority, speciality, workshop_id)  VALUES ('Maciej', 'Pień', 8, 'diagnostic', 4);
INSERT INTO car_workshop_manager.mechanics (first_name, last_name, seniority, speciality, workshop_id)  VALUES ('Wojciech', 'Długi', 4, 'bodywork', 4);

INSERT INTO car_workshop_manager.roles (name) VALUES ('ADMIN'), ('USER');