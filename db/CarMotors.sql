
CREATE DATABASE IF NOT EXISTS carmotors_db;
USE carmotors_db;

-- Tabla de Proveedores
CREATE TABLE IF NOT EXISTS suppliers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    nit VARCHAR(20) NOT NULL,
    contact VARCHAR(100),
    visit_frequency VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla de Repuestos
CREATE TABLE IF NOT EXISTS spare_parts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type ENUM('Mecánico', 'Eléctrico', 'Carrocería', 'Consumo') NOT NULL,
    brand VARCHAR(50),
    model VARCHAR(50),
    supplier_id INT,
    stock INT NOT NULL,
    min_stock INT NOT NULL,
    entry_date DATE,
    expiry_date DATE,
    status ENUM('Disponible', 'Reservado', 'Fuera de servicio') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (supplier_id) REFERENCES suppliers(id) ON DELETE CASCADE
);

-- Tabla de Lotes de Repuestos
CREATE TABLE IF NOT EXISTS spare_part_lots (
    id INT AUTO_INCREMENT PRIMARY KEY,
    spare_part_id INT,
    batch_code CHAR(50) NOT NULL,
    entry_date DATE,
    quantity INT NOT NULL,
    supplier_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (spare_part_id) REFERENCES spare_parts(id) ON DELETE CASCADE,
    FOREIGN KEY (supplier_id) REFERENCES suppliers(id) ON DELETE CASCADE
);

-- Tabla de Órdenes de Compra
CREATE TABLE IF NOT EXISTS purchase_orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    supplier_id INT,
    order_date DATE,
    status ENUM('Pendiente', 'Enviada', 'Recibida') NOT NULL,
    total_cost DECIMAL(10, 2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (supplier_id) REFERENCES suppliers(id) ON DELETE CASCADE
);

-- Tabla de Detalles de Órdenes de Compra
CREATE TABLE IF NOT EXISTS purchase_order_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    purchase_order_id INT,
    spare_part_id INT,
    quantity INT NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL,
    subtotal DECIMAL(10, 2) GENERATED ALWAYS AS (quantity * unit_price) STORED,
    FOREIGN KEY (purchase_order_id) REFERENCES purchase_orders(id) ON DELETE CASCADE,
    FOREIGN KEY (spare_part_id) REFERENCES spare_parts(id) ON DELETE CASCADE
);

-- Tabla de Clientes
CREATE TABLE IF NOT EXISTS clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    identification VARCHAR(20) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla de Vehículos
CREATE TABLE IF NOT EXISTS vehicles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    brand VARCHAR(50),
    model VARCHAR(50),
    plate VARCHAR(20) NOT NULL,
    type ENUM('Automóvil', 'SUV', 'Motocicleta', 'Otro'),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE
);

-- Tabla de Técnicos
CREATE TABLE IF NOT EXISTS technicians (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specialty VARCHAR(50),
    contact VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla de Servicios de Mantenimiento
CREATE TABLE IF NOT EXISTS maintenance_services (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT,
    type ENUM('Preventivo', 'Correctivo') NOT NULL,
    description TEXT,
    labor_cost DECIMAL(10, 2),
    status ENUM('Pendiente', 'En proceso', 'Completado', 'Entregado') NOT NULL,
    start_date DATETIME,
    end_date DATETIME,
    technician_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id) ON DELETE CASCADE,
    FOREIGN KEY (technician_id) REFERENCES technicians(id) ON DELETE CASCADE
);

-- Tabla de Detalles de Servicios
CREATE TABLE IF NOT EXISTS service_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    maintenance_service_id INT,
    spare_part_id INT,
    quantity_used INT NOT NULL,
    FOREIGN KEY (maintenance_service_id) REFERENCES maintenance_services(id) ON DELETE CASCADE,
    FOREIGN KEY (spare_part_id) REFERENCES spare_parts(id) ON DELETE CASCADE
);

-- Tabla de Historial de Servicios
CREATE TABLE IF NOT EXISTS service_history (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT,
    maintenance_service_id INT,
    date DATETIME,
    description TEXT,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id) ON DELETE CASCADE,
    FOREIGN KEY (maintenance_service_id) REFERENCES maintenance_services(id) ON DELETE CASCADE
);

-- Tabla de Facturas
CREATE TABLE IF NOT EXISTS invoices (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    maintenance_service_id INT,
    issue_date DATETIME NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    cufe VARCHAR(100),
    qr_code VARCHAR(255),
    status ENUM('Pagada', 'Pendiente') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE,
    FOREIGN KEY (maintenance_service_id) REFERENCES maintenance_services(id) ON DELETE CASCADE
);

-- Tabla de Detalles de Facturas
CREATE TABLE IF NOT EXISTS invoice_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    invoice_id INT,
    description TEXT,
    quantity INT NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (invoice_id) REFERENCES invoices(id) ON DELETE CASCADE
);

-- Tabla de Productos Suministrados
CREATE TABLE IF NOT EXISTS supplier_products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    supplier_id INT,
    spare_part_id INT,
    supply_date DATE,
    quantity INT NOT NULL,
    unit_price DECIMAL(10, 2),
    FOREIGN KEY (supplier_id) REFERENCES suppliers(id) ON DELETE CASCADE,
    FOREIGN KEY (spare_part_id) REFERENCES spare_parts(id) ON DELETE CASCADE
);

-- Tabla de Evaluación de Proveedores
CREATE TABLE IF NOT EXISTS supplier_evaluations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    supplier_id INT,
    evaluation_date DATE,
    punctuality_score INT,
    quality_score INT,
    cost_score INT,
    overall_score INT,
    FOREIGN KEY (supplier_id) REFERENCES suppliers(id) ON DELETE CASCADE
);

-- Tabla de Campañas de Mantenimiento Preventivo
CREATE TABLE IF NOT EXISTS preventive_maintenance_campaigns (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    start_date DATE,
    end_date DATE,
    description TEXT,
    discount_percentage DECIMAL(5, 2)
);

-- Tabla de Citas
CREATE TABLE IF NOT EXISTS appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    vehicle_id INT,
    campaign_id INT,
    appointment_date DATETIME,
    status ENUM('Programada', 'Cancelada', 'Completada') NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id) ON DELETE CASCADE,
    FOREIGN KEY (campaign_id) REFERENCES preventive_maintenance_campaigns(id) ON DELETE CASCADE
);

-- Tabla de Inspecciones Técnicas
CREATE TABLE IF NOT EXISTS technical_inspections (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT,
    inspection_date DATE,
    result ENUM('Aprobado', 'Reparaciones Necesarias', 'Rechazado') NOT NULL,
    notes TEXT,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id) ON DELETE CASCADE
);

-- Tabla de Programación de Revisiones
CREATE TABLE IF NOT EXISTS inspection_schedules (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT,
    next_inspection_date DATE,
    reminder_sent ENUM('Sí', 'No') DEFAULT 'No',
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id) ON DELETE CASCADE
);

-- Índices para mejorar el rendimiento
CREATE INDEX idx_spare_parts_supplier ON spare_parts(supplier_id);
CREATE INDEX idx_vehicles_client ON vehicles(client_id);
CREATE INDEX idx_maintenance_services_vehicle ON maintenance_services(vehicle_id);
CREATE INDEX idx_invoices_client ON invoices(client_id);
CREATE INDEX idx_spare_part_lots_batch_code ON spare_part_lots(batch_code);
CREATE INDEX idx_maintenance_services_technician ON maintenance_services(technician_id);

-- Crear el usuario 'Admin' accesible desde cualquier IP
CREATE USER 'Admin'@'localhost' IDENTIFIED BY 'CarMotorAdmin1?';

-- Otorgar todos los privilegios sobre la base de datos carmotors_db
GRANT ALL PRIVILEGES ON carmotors_db.* TO 'Admin'@'localhost';

-- Aplicar los cambios de privilegios
FLUSH PRIVILEGES;




