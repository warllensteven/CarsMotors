use carmotors_db;
-- INSERTS INTO suppliers
INSERT INTO suppliers (name, nit, contact, visit_frequency) VALUES ('AutoRepuestos S.A.', '900123456', 'contacto@autorepuestos.com', 'Mensual');
INSERT INTO suppliers (name, nit, contact, visit_frequency) VALUES ('TecnoPartes Ltda.', '900654321', 'ventas@tecnopartes.com', 'Quincenal');
INSERT INTO suppliers (name, nit, contact, visit_frequency) VALUES ('MotoParts Colombia', '901112233', 'info@motoparts.co', 'Semanal');
INSERT INTO suppliers (name, nit, contact, visit_frequency) VALUES ('Rincon del Repuesto', '902334455', 'soporte@rinconrepuesto.com', 'Trimestral');
INSERT INTO suppliers (name, nit, contact, visit_frequency) VALUES ('Distribuciones MECA', '903445566', 'contacto@distribucionesmeca.com', 'Mensual');

-- INSERTS INTO clients
INSERT INTO clients (name, identification, phone, email) VALUES ('Carlos Pérez', '123456789', '3114567890', 'carlos@gmail.com');
INSERT INTO clients (name, identification, phone, email) VALUES ('Laura Gómez', '987654321', '3101234567', 'laura@gmail.com');
INSERT INTO clients (name, identification, phone, email) VALUES ('Andrés Díaz', '456789123', '3001122334', 'andresd@hotmail.com');
INSERT INTO clients (name, identification, phone, email) VALUES ('Juliana Ruiz', '321654987', '3123344556', 'juliana@ruiz.com');
INSERT INTO clients (name, identification, phone, email) VALUES ('Manuel Torres', '789123456', '3205566778', 'manuel@torres.co');

-- INSERTS INTO technicians
INSERT INTO technicians (name, specialty, contact) VALUES ('Pedro Gómez', 'Motor', 'pedro@gomez.com');
INSERT INTO technicians (name, specialty, contact) VALUES ('Ana María', 'Electricidad', 'ana@taller.com');
INSERT INTO technicians (name, specialty, contact) VALUES ('Luis Torres', 'Carrocería', 'luis@torres.com');
INSERT INTO technicians (name, specialty, contact) VALUES ('Camila Díaz', 'Frenos', 'camila@workshop.co');
INSERT INTO technicians (name, specialty, contact) VALUES ('Jorge Restrepo', 'General', 'jorge@restrepo.com');

-- INSERTS INTO vehicles
INSERT INTO vehicles (client_id, brand, model, plate, type) VALUES (1, 'Mazda', '2018', 'ABC123', 'Automóvil');
INSERT INTO vehicles (client_id, brand, model, plate, type) VALUES (2, 'Mazda', '2020', 'ABC223', 'Motocicleta');
INSERT INTO vehicles (client_id, brand, model, plate, type) VALUES (3, 'Renault', '2019', 'ABC323', 'Otro');
INSERT INTO vehicles (client_id, brand, model, plate, type) VALUES (4, 'Renault', '2020', 'ABC423', 'Automóvil');
INSERT INTO vehicles (client_id, brand, model, plate, type) VALUES (5, 'Renault', '2019', 'ABC523', 'Motocicleta');

-- INSERTS INTO spare_parts
INSERT INTO spare_parts (name, type, brand, model, supplier_id, stock, min_stock, entry_date, expiry_date, status) VALUES ('Bateria', 'Eléctrico', 'Valeo', 'M12023', 5, 26, 8, '2025-04-18', '2025-08-17', 'Reservado');
INSERT INTO spare_parts (name, type, brand, model, supplier_id, stock, min_stock, entry_date, expiry_date, status) VALUES ('Aceite', 'Consumo', 'Bosch', 'M22023', 3, 17, 14, '2025-03-26', '2025-07-04', 'Reservado');
INSERT INTO spare_parts (name, type, brand, model, supplier_id, stock, min_stock, entry_date, expiry_date, status) VALUES ('Biela', 'Mecánico', 'Bosch', 'M32023', 4, 26, 15, '2025-03-24', '2025-07-10', 'Reservado');
INSERT INTO spare_parts (name, type, brand, model, supplier_id, stock, min_stock, entry_date, expiry_date, status) VALUES ('Liquido de frenos', 'Consumo', 'Valeo', 'M42023', 2, 47, 5, '2025-03-15', '2025-07-27', 'Disponible');
INSERT INTO spare_parts (name, type, brand, model, supplier_id, stock, min_stock, entry_date, expiry_date, status) VALUES ('Estabilizador', 'Eléctrico', 'NGK', 'M52023', 4, 13, 6, '2025-04-03', '2025-09-12', 'Reservado');

-- INSERTS INTO suppliers
INSERT INTO suppliers (name, nit, contact, visit_frequency) VALUES ('AutoRepuestos S.A.', '900123456', 'contacto@autorepuestos.com', 'Mensual');
INSERT INTO suppliers (name, nit, contact, visit_frequency) VALUES ('TecnoPartes Ltda.', '900654321', 'ventas@tecnopartes.com', 'Quincenal');
INSERT INTO suppliers (name, nit, contact, visit_frequency) VALUES ('MotoParts Colombia', '901112233', 'info@motoparts.co', 'Semanal');
INSERT INTO suppliers (name, nit, contact, visit_frequency) VALUES ('Rincon del Repuesto', '902334455', 'soporte@rinconrepuesto.com', 'Trimestral');
INSERT INTO suppliers (name, nit, contact, visit_frequency) VALUES ('Distribuciones MECA', '903445566', 'contacto@distribucionesmeca.com', 'Mensual');

-- INSERTS INTO clients
INSERT INTO clients (name, identification, phone, email) VALUES ('Carlos Pérez', '123456789', '3114567890', 'carlos@gmail.com');
INSERT INTO clients (name, identification, phone, email) VALUES ('Laura Gómez', '987654321', '3101234567', 'laura@gmail.com');
INSERT INTO clients (name, identification, phone, email) VALUES ('Andrés Díaz', '456789123', '3001122334', 'andresd@hotmail.com');
INSERT INTO clients (name, identification, phone, email) VALUES ('Juliana Ruiz', '321654987', '3123344556', 'juliana@ruiz.com');
INSERT INTO clients (name, identification, phone, email) VALUES ('Manuel Torres', '789123456', '3205566778', 'manuel@torres.co');

-- INSERTS INTO technicians
INSERT INTO technicians (name, specialty, contact) VALUES ('Pedro Gómez', 'Motor', 'pedro@gomez.com');
INSERT INTO technicians (name, specialty, contact) VALUES ('Ana María', 'Electricidad', 'ana@taller.com');
INSERT INTO technicians (name, specialty, contact) VALUES ('Luis Torres', 'Carrocería', 'luis@torres.com');
INSERT INTO technicians (name, specialty, contact) VALUES ('Camila Díaz', 'Frenos', 'camila@workshop.co');
INSERT INTO technicians (name, specialty, contact) VALUES ('Jorge Restrepo', 'General', 'jorge@restrepo.com');

-- INSERTS INTO vehicles
INSERT INTO vehicles (client_id, brand, model, plate, type) VALUES (1, 'Mazda', '2018', 'ABC123', 'Automóvil');
INSERT INTO vehicles (client_id, brand, model, plate, type) VALUES (2, 'Mazda', '2020', 'ABC223', 'Motocicleta');
INSERT INTO vehicles (client_id, brand, model, plate, type) VALUES (3, 'Renault', '2019', 'ABC323', 'Otro');
INSERT INTO vehicles (client_id, brand, model, plate, type) VALUES (4, 'Renault', '2020', 'ABC423', 'Automóvil');
INSERT INTO vehicles (client_id, brand, model, plate, type) VALUES (5, 'Renault', '2019', 'ABC523', 'Motocicleta');

-- INSERTS INTO spare_parts
INSERT INTO spare_parts (name, type, brand, model, supplier_id, stock, min_stock, entry_date, expiry_date, status) VALUES ('Bateria', 'Eléctrico', 'Valeo', 'M12023', 5, 26, 8, '2025-04-18', '2025-08-17', 'Reservado');
INSERT INTO spare_parts (name, type, brand, model, supplier_id, stock, min_stock, entry_date, expiry_date, status) VALUES ('Aceite', 'Consumo', 'Bosch', 'M22023', 3, 17, 14, '2025-03-26', '2025-07-04', 'Reservado');
INSERT INTO spare_parts (name, type, brand, model, supplier_id, stock, min_stock, entry_date, expiry_date, status) VALUES ('Biela', 'Mecánico', 'Bosch', 'M32023', 4, 26, 15, '2025-03-24', '2025-07-10', 'Reservado');
INSERT INTO spare_parts (name, type, brand, model, supplier_id, stock, min_stock, entry_date, expiry_date, status) VALUES ('Liquido de frenos', 'Consumo', 'Valeo', 'M42023', 2, 47, 5, '2025-03-15', '2025-07-27', 'Disponible');
INSERT INTO spare_parts (name, type, brand, model, supplier_id, stock, min_stock, entry_date, expiry_date, status) VALUES ('Estabilizador', 'Eléctrico', 'NGK', 'M52023', 4, 13, 6, '2025-04-03', '2025-09-12', 'Reservado');



DESCRIBE maintenance_services ;