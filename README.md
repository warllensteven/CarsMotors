# CarMotorsWorkshop

Welcome to CarMotorsWorkshop, a Java-based application designed to manage a car workshop's operations. This project includes modules for inventory management, maintenance, client billing, supplier management, and statistics reporting.

## Project Overview

CarMotorsWorkshop is a desktop application built using Java Swing and Maven. It provides a user-friendly interface to handle various aspects of a car workshop, including:

- **Inventory Management**: Track spare parts and supplies.
- **Maintenance and Repairs**: Manage repair orders and schedules.
- **Clients and Billing**: Handle client information and generate invoices.
- **Suppliers and Purchases**: Manage supplier details and purchase orders.
- **Reports and Statistics**: Generate performance reports and statistics.

## Requirements

To run or contribute to this project, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 17 or higher (e.g., JDK 23).
- **Maven**: Version 3.6.0 or higher for building the project.
- **Git**: For cloning the repository and managing version control.
- **NetBeans IDE** (optional): Recommended for editing the GUI forms, though any Java IDE (e.g., IntelliJ IDEA) can work.
- **Operating System**: Windows, macOS, or Linux (tested on Windows).

## Installation

Follow these steps to set up the project on your local machine:

1. **Clone the Repository:**
   Open a terminal and run:
   git clone https://github.com/warllensteven/CarasMotors.git
   cd CarMotorsWorkshop

2. **Install Dependencies:**
   Ensure Maven is configured to use the correct JDK. Set the `JAVA_HOME` environment variable to your JDK path (e.g., `C:\Program Files\Java\jdk-17` on Windows).
   Verify Maven setup:
   mvn -version

3. **Build the Project:**
   Compile and package the project using Maven:
   mvn clean install -U

This will download dependencies and build the application.

## Running the Application

To execute the application, use the following command in the project directory:

- **Note:** Adjust the paths (`JAVA_HOME`, NetBeans location) based on your system configuration.
- The application will launch a GUI window with navigation options for different modules.

## Usage

- Click the buttons on the left sidebar to navigate between modules:
  - **Gestion Inventario**: Manage inventory.
  - **Mantenimiento y Reparaciones**: Handle maintenance tasks.
  - **Clientes y Facturación**: Manage clients and billing.
  - **Proveedores y Compras**: Manage suppliers and purchase orders.
  - **Reportes y Estadísticas**: View performance reports.
- Use the "X" button to exit the application.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -m "Add new feature"`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a pull request on GitHub.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use, modify, and distribute it as per the license terms.

## Contact

For questions or support, contact the project maintainers:

- **Daniel Rodríguez**: [daniel@example.com](mailto:daniel@example.com)
- **Warllen Romero**: [warllensteven@gmail.com](mailto:warllensteven@gmail.com)
- **GitHub**: [warllensteven](https://github.com/warllensteven)

## Acknowledgments

- Thanks to the open-source community for tools like Maven and Java Swing.
- Special thanks to Daniel Rodríguez and Warllen Romero for their contributions to this project.
