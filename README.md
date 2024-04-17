### Hibernate Project: Mapping and Functionality

#### Functionality and Technologies

### Functionality:
This project aims to demonstrate the implementation of Hibernate ORM (Object-Relational Mapping) to interact with a MySQL database. Below are the key functionalities implemented:

1. **Customer Management**:
   - Creation of new customers with all associated fields.
   - Return of previously rented films by customers.

2. **Film Rental Operations**:
   - Rental of inventory (films) at the store.
   - Payment handling for rentals.
   - Updating availability status of films after rentals.

### Technologies Used:
- **Hibernate ORM**: Utilized for mapping Java objects to database tables and vice versa. It simplifies data persistence and enables seamless interaction with the database.
- **Java Persistence API (JPA)**: Implemented to provide a standardized interface for ORM frameworks like Hibernate.
- **MySQL Database**: Used as the underlying database system for storing and managing data.
- **Maven**: Employed as the project management and comprehension tool, facilitating dependency management and project building.
- **IntelliJ IDEA**: Chosen as the Integrated Development Environment (IDE) for its robust features and seamless integration with Hibernate and Maven.

### Project Structure:
The project structure follows Maven conventions and includes the following key components:
- **Entity Classes**: Java classes representing database entities, annotated with Hibernate annotations for mapping.
- **Service Classes**: Java classes containing methods for customer and film rental operations.
- **Configuration Files**: Hibernate configuration files (e.g., `hibernate.cfg.xml`) for specifying database connection properties and entity mappings.
- **Maven Configuration**: `pom.xml` file defining project dependencies and build configurations.
