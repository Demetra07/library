package gr.university.library;

import gr.university.library.contracts.Searchable;
import gr.university.library.model.*;
import java.util.ArrayList;

public class Library implements Searchable {

    // Οι 3 βασικές λίστες του συστήματός
    private ArrayList<LibraryItem> items;
    private ArrayList<Member> members;
    private ArrayList<Loan> loans;

    //Αρχικοποίηση για τις άδειες λίστες
    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    //Μέθοδοι Προσθήκης items
    public void addItem(LibraryItem item) {
        if (item != null) {
            items.add(item);
            System.out.println("Το αντικείμενο προστέθηκε επιτυχώς στη βιβλιοθήκη.");
        }
    }

    public void addMember(Member member) {
        if (member != null) {
            members.add(member);
            System.out.println("Το μέλος εγγράφηκε επιτυχώς στη βιβλιοθήκη.");
        }
    }

    //Αναζήτηση
    @Override
    public LibraryItem findItemByCode(String code) {
        for (LibraryItem item : items) {
            if (item.getId().equals(code)) {
                return item; // Βρέθηκε!
            }
        }
        return null; // Δεν βρέθηκε
    }

    @Override
    public Member findMemberById(String id) {
        for (Member m : members) {
            if (m.getId().equals(id)) {
                return m; // Βρέθηκε!
            }
        }
        return null; // Δεν βρέθηκε
    }

    public boolean registerLoan(String memberId, String itemCode, String date) {
        Member member = findMemberById(memberId);
        LibraryItem item = findItemByCode(itemCode);

        // Έλεγχος 1: Υπάρχουν το μέλος και το βιβλίο;
        if (member == null || item == null) {
            System.out.println("Σφάλμα: Δεν βρέθηκε το μέλος ή το αντικείμενο.");
            return false;
        }

        // Έλεγχος 2: Έχει ξεπεράσει το μέλος το όριο δανεισμών του;
        if (countActiveLoans(member) >= member.getMaxLoans()) {
            System.out.println("Σφάλμα: Το μέλος έχει φτάσει το μέγιστο όριο δανεισμών.");
            return false;
        }

        // Έλεγχος 3: Είναι το βιβλίο διαθέσιμο; Αν ναι, γίνεται δανεισμός!
        if (item.borrowTo(member)) {
            loans.add(new Loan(member, item, date));
            return true;
        }

        return false;
    }

    //Επιστροφή βιβλίου
    public void returnItem(String itemCode, String returnDate) {
        LibraryItem item = findItemByCode(itemCode);
        if (item != null) {
            item.returnItem(); // Αλλάζει τη διαθεσιμότητα ξανά σε true
            // Βρίσκουμε τον ενεργό δανεισμό και του βάζουμε ημερομηνία επιστροφής
            for (Loan loan : loans) {
                if (loan.getItem().getId().equals(itemCode) && loan.getReturnDate() == null) {
                    loan.setReturnDate(returnDate);
                    break;
                }
            }
        } else {
            System.out.println("Σφάλμα: Δεν βρέθηκε αντικείμενο με αυτόν τον κωδικό.");
        }
    }

    //μέθοδος για να μετράμε πόσα βιβλία χρωστάει κάθε μέλος
    private int countActiveLoans(Member m) {
        int count = 0;
        for (Loan l : loans) {
            // Αν ο δανεισμός αφορά αυτό το μέλος και δεν υπάρχει ημερομηνία επιστροφής
            if (l.getMember().getId().equals(m.getId()) && l.getReturnDate() == null) {
                count++;
            }
        }
        return count;
    }

    // Getters για τις λίστες (για την ReportGenerator)
    public ArrayList<LibraryItem> getItems() { return items; }
    public ArrayList<Member> getMembers() { return members; }
    public ArrayList<Loan> getLoans() { return loans; }
}
