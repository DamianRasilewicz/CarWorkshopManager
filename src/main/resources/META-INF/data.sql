INSERT INTO car_workshop_manager.workshops (city, street, number) VALUES ('Wroclaw', 'Wiejska', 3);
INSERT INTO car_workshop_manager.workshops (city, street, number) VALUES ('Warsaw', 'Warszatowa', 16);
INSERT INTO car_workshop_manager.workshops (city, street, number) VALUES ('Zielona Gora', 'Kluczowa', 6);
INSERT INTO car_workshop_manager.workshops (city, street, number) VALUES ('Poznań', 'Naprawialna', 12);

INSERT INTO car_workshop_manager.tasks (description, estimated_execution_time, estimated_cost) VALUES ('front suspension replacement', 6, 600);
INSERT INTO car_workshop_manager.tasks (description, estimated_execution_time, estimated_cost) VALUES ('rear suspension replacement', 4.5, 450);
INSERT INTO car_workshop_manager.tasks (description, estimated_execution_time, estimated_cost) VALUES ('timing belt/chain replacement', 6, 600);
INSERT INTO car_workshop_manager.tasks (description, estimated_execution_time, estimated_cost) VALUES ('tire change with balance', 1, 100);
INSERT INTO car_workshop_manager.tasks (description, estimated_execution_time, estimated_cost) VALUES ('filters(oil,air,fuel,cabin) replacement', 2, 200);
INSERT INTO car_workshop_manager.tasks (description, estimated_execution_time, estimated_cost) VALUES ('engine oil replacement', 0.5, 50);
INSERT INTO car_workshop_manager.tasks (description, estimated_execution_time, estimated_cost) VALUES ('automatic transmission oil replacement', 4, 400);

INSERT INTO car_workshop_manager.mechanics (first_name, last_name, seniority, speciality, workshop_id)  VALUES ('Adam', 'Kowalski', 6, 'suspensions', 1);
INSERT INTO car_workshop_manager.mechanics (first_name, last_name, seniority, speciality, workshop_id)  VALUES ('Jan', 'Polak', 3, 'tires', 1);
INSERT INTO car_workshop_manager.mechanics (first_name, last_name, seniority, speciality, workshop_id)  VALUES ('Andrzej', 'Wit', 7, 'filters', 2);
INSERT INTO car_workshop_manager.mechanics (first_name, last_name, seniority, speciality, workshop_id)  VALUES ('Paweł', 'Czerniowki', 2, 'engines', 2);
INSERT INTO car_workshop_manager.mechanics (first_name, last_name, seniority, speciality, workshop_id)  VALUES ('Damian', 'Rosina', 5, 'electronics', 3);
INSERT INTO car_workshop_manager.mechanics (first_name, last_name, seniority, speciality, workshop_id)  VALUES ('Tomasz', 'Kwieciński', 6, 'varnishing', 3);
INSERT INTO car_workshop_manager.mechanics (first_name, last_name, seniority, speciality, workshop_id)  VALUES ('Maciej', 'Pień', 8, 'diagnostic', 4);
INSERT INTO car_workshop_manager.mechanics (first_name, last_name, seniority, speciality, workshop_id)  VALUES ('Wojciech', 'Długi', 4, 'bodywork', 4);

INSERT INTO car_workshop_manager.roles (name) VALUES ('ADMIN'), ('USER');

INSERT INTO car_workshop_manager.users (email, first_name, last_name, user_name, password, phone_number, registered, enabled) VALUES ('user@gmail.com', 'Jan', 'Kowalski',
                                                                                                                 'user', '$2y$12$um7q2OHsp5kf4hHmdR.C1OhL8wBXlXJ8x5m9YMJJPPbePQEjaZCny', 668875423, true, true);
INSERT INTO car_workshop_manager.users (email, first_name, last_name, phone_number, registered) VALUES ('andrzej345@wp.pl', 'Andrzej', 'Korzeń',
                                                                                                        856982236, false);

INSERT INTO car_workshop_manager.user_role (role_id, user_id) VALUES (2, 1);
INSERT INTO car_workshop_manager.user_role (role_id, user_id) VALUES (2, 2);

INSERT INTO car_workshop_manager.cars (brand, model, production_year, engine_capacity, engine_power, engine_type, user_id) VALUES ('Audi', 'A6', '2008',
                                                                                                                                   '2700', '180KM', 'Diesel', 1);
INSERT INTO car_workshop_manager.cars (brand, model, production_year, engine_capacity, engine_power, engine_type, user_id) VALUES ('BMW', '5', '2001',
                                                                                                                                   '2.5L', '192KM', 'Benzine', 2);

INSERT INTO car_workshop_manager.orders (status, estimated_execution_time, estimated_work_cost, parts_cost, work_cost, working_hours, final_cost, comment, car_id, user_id) VALUES ('Done', 16.5, 1650, 500, 1650, 16.5, 2150,'none', 1, 1);
INSERT INTO car_workshop_manager.orders (status, user_id) VALUES ('In progress', 2);

INSERT INTO car_workshop_manager.visit_dates (date, time, order_id, workshop_id) VALUES ('2021-05-20', '13:00', 1, 1);
INSERT INTO car_workshop_manager.visit_dates (date, time, order_id, workshop_id) VALUES ('2021-05-17', '10:30', 2, 4);

INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (1, 1);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (1, 2);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (1, 3);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (2, 4);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (2, 5);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (2, 6);

INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (1, 1);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (1, 2);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (2, 3);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (2, 4);
