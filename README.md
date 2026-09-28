# University Library Management System

A production-ready console-based application written in **Java 26**, implementing a comprehensive domain model for university library operations. Developed as part of the Object-Oriented Programming coursework under the supervision of Assoc. Prof. C. Alepis at the University of Piraeus (Department of Informatics).

##  Core Functionality

- **Item Management:** Cataloging and multi-criteria searching for diverse library media (`Book`, `Magazine`, `DigitalBook`).
- **Member Profiles:** Role-specific business logic for Students and Professors, enforcing distinct borrowing capacity thresholds and duration limits.
- **Transaction Engine:** Safe borrowing and return operations backed by strict validation checks (item availability, eligibility, user loan limits).
- **Analytics & Reporting:** Dynamic report generation tracking active loans, media popularity, and user history.

##  Architecture & OOP Design

- **Language & Runtime:** Java 26
- **Object-Oriented Pillars:**
    - **Inheritance & Abstraction:** Polymorphic hierarchy branching from core abstract entities (`LibraryItem`, `User`).
    - **Interface Contracts:** Loose coupling achieved via `Borrowable` and `Searchable` interfaces.
    - **Encapsulation:** Immutable identifiers, private fields, and defensive validation logic to guarantee valid domain states.
- **Data Structures:** Java Collections Framework (`ArrayList`) for dynamic in-memory state management.

##  Execution & Setup

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/Demetra07/library.git](https://github.com/Demetra07/library.git)
  
2. Open in IDE: Import the project into IntelliJ IDEA, Eclipse, or VS Code.

3. Run the Application: Execute the main entry point: gr.university.library.Main 
   