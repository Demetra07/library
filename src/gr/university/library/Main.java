package gr.university.library;

import gr.university.library.model.*;
import gr.university.library.util.ReportGenerator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        //Προ-φόρτωση Δεδομένων
        System.out.println("Φόρτωση αρχικών δεδομένων...");
        library.addItem(new Book("B001", "Αντικειμενοστρεφής Προγραμματισμός", 2023, "Γ. Παπαδόπουλος", "978-1234567890"));
        library.addItem(new Magazine("M001", "Java Today", 2024, 42));
        library.addMember(new StudentMember("S001", "Μαρία Κώστα", "maria@uni.gr", 5, "cs1029", "Πληροφορικής"));
        library.addMember(new ProfessorMember("P001", "Νίκος Ανδρέου", "nandreas@uni.gr", 10, "Μηχανική Λογισμικού"));
        System.out.println("Η βιβλιοθήκη είναι έτοιμη!\n");

        //Το Μενού της Κονσόλας
        boolean running = true;
        while (running) {
            System.out.println("\n=== University Library ===");
            System.out.println("1. Προσθήκη υλικού βιβλιοθήκης (Βιβλίο)");
            System.out.println("2. Προσθήκη μέλους (Φοιτητής)");
            System.out.println("3. Αναζήτηση υλικού βιβλιοθήκης");
            System.out.println("4. Δανεισμός υλικού βιβλιοθήκης");
            System.out.println("5. Επιστροφή υλικού βιβλιοθήκης");
            System.out.println("6. Εμφάνιση ενεργών δανεισμών");
            System.out.println("7. Στατιστικά βιβλιοθήκης");
            System.out.println("0. Έξοδος");
            System.out.print("Επιλογή: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Δώσε Κωδικό: ");
                    String id = scanner.nextLine();
                    System.out.print("Δώσε Τίτλο: ");
                    String title = scanner.nextLine();
                    System.out.print("Δώσε Έτος (π.χ. 2024): ");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.print("Δώσε Συγγραφέα: ");
                    String author = scanner.nextLine();
                    System.out.print("Δώσε ISBN: ");
                    String isbn = scanner.nextLine();

                    library.addItem(new Book(id, title, year, author, isbn));
                    break;

                case "2":
                    System.out.print("Δώσε ID Μέλους: ");
                    String mId = scanner.nextLine();
                    System.out.print("Δώσε Όνομα: ");
                    String name = scanner.nextLine();
                    System.out.print("Δώσε Email (πρέπει να έχει @): ");
                    String email = scanner.nextLine();
                    System.out.print("Δώσε Αριθμό Μητρώου: ");
                    String am = scanner.nextLine();
                    System.out.print("Δώσε Τμήμα: ");
                    String dep = scanner.nextLine();

                    // Δίνουμε maxLoans=5 by default για τους φοιτητές
                    library.addMember(new StudentMember(mId, name, email, 5, am, dep));
                    break;

                case "3":
                    System.out.print("Δώσε Κωδικό Αντικειμένου για αναζήτηση: ");
                    String searchCode = scanner.nextLine();
                    LibraryItem foundItem = library.findItemByCode(searchCode);
                    if (foundItem != null) {
                        System.out.println("Βρέθηκε: " + foundItem.getDescription());
                        System.out.println("Διαθέσιμο: " + (foundItem.isAvailable() ? "Ναι" : "Όχι"));
                    } else {
                        System.out.println("Δεν βρέθηκε αντικείμενο με αυτόν τον κωδικό.");
                    }
                    break;

                case "4":
                    System.out.print("Δώσε ID Μέλους που κάνει τον δανεισμό (π.χ. S001): ");
                    String loanMemberId = scanner.nextLine();
                    System.out.print("Δώσε Κωδικό Αντικειμένου (π.χ. B001): ");
                    String loanItemId = scanner.nextLine();
                    System.out.print("Δώσε Σημερινή Ημερομηνία (π.χ. 20/05/2026): ");
                    String date = scanner.nextLine();

                    if (library.registerLoan(loanMemberId, loanItemId, date)) {
                        System.out.println("Ο δανεισμός καταχωρήθηκε επιτυχώς!");
                    } else {
                        System.out.println("Αποτυχία δανεισμού (δείτε τα παραπάνω μηνύματα).");
                    }
                    break;

                case "5":
                    System.out.print("Δώσε Κωδικό Αντικειμένου προς επιστροφή: ");
                    String returnCode = scanner.nextLine();
                    System.out.print("Δώσε Ημερομηνία Επιστροφής: ");
                    String rDate = scanner.nextLine();
                    library.returnItem(returnCode, rDate);
                    break;

                case "6":
                    ReportGenerator.printActiveLoans(library);
                    break;

                case "7":
                    ReportGenerator.printLibraryStatistics(library);
                    break;

                case "0":
                    running = false;
                    System.out.println("Τερματισμός εφαρμογής. Καλή συνέχεια!");
                    break;

                default:
                    System.out.println("Λάθος επιλογή. Παρακαλώ δοκιμάστε ξανά.");
            }
        }
        scanner.close();
    }
}
