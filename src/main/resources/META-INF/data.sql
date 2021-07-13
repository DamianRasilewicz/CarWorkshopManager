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

INSERT INTO car_workshop_manager.users (email, first_name, last_name, user_name, password, phone_number, registered, enabled, role_id, registered_date, registered_day, registered_month, registered_year) VALUES ('rasil754@gmail.com', 'Jan', 'Kowalski',
                                                                                                                 'User', '$2y$12$um7q2OHsp5kf4hHmdR.C1OhL8wBXlXJ8x5m9YMJJPPbePQEjaZCny', 668875423, true, true, 2, '2021-01-02', 2, 1, 2021);
INSERT INTO car_workshop_manager.users (email, first_name, last_name, user_name, password, phone_number, registered, enabled, role_id, registered_date, registered_day, registered_month, registered_year) VALUES ('rasil754@gmail.com', 'Admin', 'Admin',
                                                                                                                                      'Admin', '$2y$12$ao279hYOuSSEtPUyB8jIi.ki2LvY9AZ4ypWR7mn2WnEd1me5Vciay', 999999999, true, true, 1, '2021-01-01', 1, 1, 2021);
INSERT INTO car_workshop_manager.users (email, first_name, last_name, user_name, password, phone_number, registered, enabled, role_id, registered_date, registered_day, registered_month, registered_year) VALUES ('rasil754@gmail.com', 'Maciej', 'Kowal',
                                                                                                                                               'Kowal237', '$2y$12$ao279hYOuSSEtPUyB8jIi.ki2LvY9AZ4ypWR7mn2WnEd1me5Vciay', 999999999, true, true, 2, '2021-05-23', 23, 5, 2021);
INSERT INTO car_workshop_manager.users (email, first_name, last_name, user_name, password, phone_number, registered, enabled, role_id, registered_date, registered_day, registered_month, registered_year) VALUES ('rasil754@gmail.com', 'Maksymilian', 'Piotrowski',
                                                                                                                                               'Pioter1990', '$2y$12$ao279hYOuSSEtPUyB8jIi.ki2LvY9AZ4ypWR7mn2WnEd1me5Vciay', 999999999, true, true, 2, '2021-08-06', 6, 8, 2021);

INSERT INTO car_workshop_manager.cars (brand, model, production_year, engine_capacity, engine_power, engine_type, user_id) VALUES ('Audi', 'A6', '2008',
                                                                                                                                   '2700', '180', 'Diesel', 1);
INSERT INTO car_workshop_manager.cars (brand, model, production_year, engine_capacity, engine_power, engine_type, user_id) VALUES ('BMW', '5', '2001',
                                                                                                                                   '2.5L', '192', 'Benzine', 1);
INSERT INTO car_workshop_manager.cars (brand, model, production_year, engine_capacity, engine_power, engine_type, user_id) VALUES ('Skoda', 'Octavia RS', '2017',
                                                                                                                                   '2.0', '235', 'Benzine', 1);
INSERT INTO car_workshop_manager.cars (brand, model, production_year, engine_capacity, engine_power, engine_type, user_id) VALUES ('VW', 'Golf', '2009',
                                                                                                                                   '2.0', '110', 'Diesle', 3);
INSERT INTO car_workshop_manager.cars (brand, model, production_year, engine_capacity, engine_power, engine_type, user_id) VALUES ('Skoda', 'Superb', '2010',
                                                                                                                                   '1.8', '160', 'Benzine', 4);

INSERT INTO car_workshop_manager.orders (status, estimated_execution_time, estimated_work_cost, parts_cost, work_cost, working_hours, final_cost, comment, car_id, user_id) VALUES ('Done', 16.5, 1650, 500, 1650, 16.5, 2150,'none', 1, 1);
INSERT INTO car_workshop_manager.orders (status, estimated_execution_time, estimated_work_cost, parts_cost, work_cost, working_hours, final_cost, comment, car_id, user_id) VALUES ('In progress', 10, 1000, 550, 1300, 12, 1850, 'none', 2, 1);
INSERT INTO car_workshop_manager.orders (status, estimated_execution_time, estimated_work_cost, parts_cost, work_cost, working_hours, final_cost, comment, car_id, user_id) VALUES ('Done', 2, 200, 250, 200, 2, 450, 'none', 2, 1);
INSERT INTO car_workshop_manager.orders (status, estimated_execution_time, estimated_work_cost, parts_cost, work_cost, working_hours, final_cost, comment, car_id, user_id) VALUES ('Done', 4, 400, 300, 400, 4, 700, 'none', 2, 1);
INSERT INTO car_workshop_manager.orders (status, estimated_execution_time, estimated_work_cost, parts_cost, work_cost, working_hours, final_cost, comment, car_id, user_id) VALUES ('Done', 5, 500, 300, 500, 5, 800, 'none', 2, 1);
INSERT INTO car_workshop_manager.orders (status, estimated_execution_time, estimated_work_cost, parts_cost, work_cost, working_hours, final_cost, comment, car_id, user_id) VALUES ('Done', 2, 200, 550, 200, 2, 750, 'none', 2, 1);
INSERT INTO car_workshop_manager.orders (status, estimated_execution_time, estimated_work_cost, parts_cost, work_cost, working_hours, final_cost, comment, car_id, user_id) VALUES ('Done', 4, 400, 100, 400, 4, 500, 'none', 2, 1);
INSERT INTO car_workshop_manager.orders (status, estimated_execution_time, estimated_work_cost, parts_cost, work_cost, working_hours, final_cost, comment, car_id, user_id) VALUES ('Done', 7, 700, 400, 700, 70, 1100, 'none', 2, 1);
INSERT INTO car_workshop_manager.orders (status, estimated_execution_time, estimated_work_cost, parts_cost, work_cost, working_hours, final_cost, comment, car_id, user_id) VALUES ('Done', 1, 100, 100, 100, 1, 200, 'none', 3, 1);
INSERT INTO car_workshop_manager.orders (status, estimated_execution_time, estimated_work_cost, parts_cost, work_cost, working_hours, final_cost, comment, car_id, user_id) VALUES ('Done', 2, 200, 200, 200, 2, 400, 'none', 3, 1);
INSERT INTO car_workshop_manager.orders (status, estimated_execution_time, estimated_work_cost, parts_cost, work_cost, working_hours, final_cost, comment, car_id, user_id) VALUES ('Done', 10, 1000, 550, 1300, 12, 1850, 'none', 3, 1);
INSERT INTO car_workshop_manager.orders (status, estimated_execution_time, estimated_work_cost, parts_cost, work_cost, working_hours, final_cost, comment, car_id, user_id) VALUES ('Waiting to approval', 9, 900, 0, 0, 0, 900,'none', 3, 3);
INSERT INTO car_workshop_manager.orders (status, estimated_execution_time, estimated_work_cost, parts_cost, work_cost, working_hours, final_cost, comment, car_id, user_id) VALUES ('Done', 5, 500, 250, 500, 5, 750,'none', 4, 4);
INSERT INTO car_workshop_manager.orders (status, estimated_execution_time, estimated_work_cost, parts_cost, work_cost, working_hours, final_cost, comment, car_id, user_id) VALUES ('In progress', 7.5, 750, 0, 0, 0, 750,'none', 4, 4);
INSERT INTO car_workshop_manager.orders (status, estimated_execution_time, estimated_work_cost, parts_cost, work_cost, working_hours, final_cost, comment, car_id, user_id) VALUES ('In progress', 6, 600, 0, 0, 0, 600,'none', 4, 4);

INSERT INTO car_workshop_manager.visit_dates (date, time, order_id, workshop_id, user_id, day, month, year) VALUES ('2021-05-20', '13:00', 1, 1, 1, 20, 5, 2021);
INSERT INTO car_workshop_manager.visit_dates (date, time, order_id, workshop_id, user_id, day, month, year) VALUES ('2021-05-17', '10:30', 2, 4, 1, 17, 5, 2021);
INSERT INTO car_workshop_manager.visit_dates (date, time, order_id, workshop_id, user_id, day, month, year) VALUES ('2021-06-12', '9:00', 3, 2, 1, 12, 6, 2021);
INSERT INTO car_workshop_manager.visit_dates (date, time, order_id, workshop_id, user_id, day, month, year) VALUES ('2021-06-20', '10:00', 4, 2, 1, 20, 6, 2021);
INSERT INTO car_workshop_manager.visit_dates (date, time, order_id, workshop_id, user_id, day, month, year) VALUES ('2021-01-03', '12:00', 5, 2, 1, 3, 1, 2021);
INSERT INTO car_workshop_manager.visit_dates (date, time, order_id, workshop_id, user_id, day, month, year) VALUES ('2021-01-12', '10:00', 6, 2, 1, 12, 1, 2021);
INSERT INTO car_workshop_manager.visit_dates (date, time, order_id, workshop_id, user_id, day, month, year) VALUES ('2021-02-20', '13:00', 7, 2, 1, 20, 2, 2021);
INSERT INTO car_workshop_manager.visit_dates (date, time, order_id, workshop_id, user_id, day, month, year) VALUES ('2021-04-04', '15:00', 8, 2, 1, 4, 4, 2021);
INSERT INTO car_workshop_manager.visit_dates (date, time, order_id, workshop_id, user_id, day, month, year) VALUES ('2021-06-17', '9:00', 9, 2, 1, 17, 6, 2021);
INSERT INTO car_workshop_manager.visit_dates (date, time, order_id, workshop_id, user_id, day, month, year) VALUES ('2021-07-12', '15:30', 10, 2, 1, 12, 7, 2021);
INSERT INTO car_workshop_manager.visit_dates (date, time, order_id, workshop_id, user_id, day, month, year) VALUES ('2021-09-17', '9:00', 11, 2, 1, 17, 9, 2021);
INSERT INTO car_workshop_manager.visit_dates (date, time, order_id, workshop_id, user_id, day, month, year) VALUES ('2021-10-20', '15:00', 12, 3, 4, 20, 10, 2021);
INSERT INTO car_workshop_manager.visit_dates (date, time, order_id, workshop_id, user_id, day, month, year) VALUES ('2021-11-28', '7:00', 13, 3, 4, 28, 11, 2021);
INSERT INTO car_workshop_manager.visit_dates (date, time, order_id, workshop_id, user_id, day, month, year) VALUES ('2021-10-20', '10:00', 14, 3, 4, 20, 10, 2021);
INSERT INTO car_workshop_manager.visit_dates (date, time, order_id, workshop_id, user_id, day, month, year) VALUES ('2021-12-05', '10:00', 15, 3, 4, 5, 12, 2021);

INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (1, 1);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (1, 2);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (1, 3);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (2, 4);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (2, 5);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (2, 6);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (3, 6);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (3, 4);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (4, 4);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (5, 4);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (6, 4);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (7, 4);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (8, 4);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (9, 4);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (10, 4);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (11, 4);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (12, 1);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (13, 2);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (14, 3);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (14, 2);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (15, 1);
INSERT INTO car_workshop_manager.orders_tasks (order_id, task_id) VALUES (15, 2);

INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (1, 1);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (1, 2);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (2, 3);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (2, 4);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (3, 5);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (3, 6);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (4, 7);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (5, 8);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (6, 8);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (7, 8);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (8, 8);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (9, 8);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (10, 8);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (11, 8);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (10, 7);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (11, 7);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (12, 7);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (13, 8);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (14, 7);
INSERT INTO car_workshop_manager.orders_mechanics (order_id, mechanic_id) VALUES (15, 8);
