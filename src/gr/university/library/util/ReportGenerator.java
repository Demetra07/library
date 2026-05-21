package gr.university.library.util;

import gr.university.library.service.Library;
import gr.university.library.model.Loan;

// καμία κλάση δεν μπορεί να κάνει extends αυτήν την κλάση
public final class ReportGenerator {

    private ReportGenerator() {}

    //Εκτύπωση γενικών στατιστικών
    public static void printLibraryStatistics(Library library) {
        System.out.println("\n=== Στατιστικά Βιβλιοθήκης ===");
        System.out.println("Συνολικό Υλικό (Βιβλία/Περιοδικά): " + library.getItems().size());
        System.out.println("Συνολικά Εγγεγραμμένα Μέλη: " + library.getMembers().size());

        int activeLoans = 0;
        for (Loan l : library.getLoans()) {
            if (l.getReturnDate() == null) {
                activeLoans++;
            }
        }
        System.out.println("Συνολικοί Ενεργοί Δανεισμοί: " + activeLoans);
        System.out.println("==============================");
    }

    //Αναλυτική εκτύπωση για το μέλος
    public static void printActiveLoans(Library library) {
        System.out.println("\n=== Λίστα Ενεργών Δανεισμών ===");
        boolean found = false;
        for (Loan l : library.getLoans()) {
            if (l.getReturnDate() == null) {
                System.out.println("- Το μέλος '" + l.getMember().getName() + "' (ID: " + l.getMember().getId() +
                        ") έχει το αντικείμενο: '" + l.getItem().getTitle() +
                        "' (Ημ. Δανεισμού: " + l.getLoanDate() + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Δεν υπάρχουν ενεργοί δανεισμοί αυτή τη στιγμή.");
        }
        System.out.println("===============================");
    }
}
