package gr.university.library.model;

public class Loan {

    // 1. Συσχέτιση: Ένας δανεισμός χρειάζεται ένα Μέλος και ένα Αντικείμενο
    private Member member;
    private LibraryItem item;
    private String loanDate;   // Ημερομηνία δανεισμού
    private String returnDate; // Ημερομηνία επιστροφής (μπορεί να είναι null αν δεν έχει επιστραφεί ακόμα)

    // 2. Constructor
    public Loan(Member member, LibraryItem item, String loanDate) {
        this.member = member;
        this.item = item;
        this.loanDate = loanDate;
        this.returnDate = null; // Αρχικά, όταν γίνεται ο δανεισμός, δεν έχει επιστραφεί ακόμα!
    }

    // 3. Getters & Setters
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LibraryItem getItem() {
        return item;
    }

    public void setItem(LibraryItem item) {
        this.item = item;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    // Μέθοδος για να ορίσουμε πότε επιστράφηκε το βιβλίο
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
