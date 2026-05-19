package gr.university.library.model;

public class Magazine extends LibraryItem {

    private int issueNumber; // Αριθμός τεύχους

    // Constructor
    public Magazine(String id, String title, int publicationYear, int issueNumber) {
        super(id, title, publicationYear); // Για χρήση Constructor του LibraryItem
        this.issueNumber = issueNumber;
    }

    // Getters & Setters
    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    // Υλοποίηση μεθόδων από το Borrowable (μέσω του LibraryItem)
    @Override
    public boolean borrowTo(Member member) {
        if (isAvailable()) {
            setAvailable(false);
            System.out.println("Το περιοδικό '" + getTitle() + "' (Τεύχος: " + issueNumber + ") δανείστηκε στο μέλος: " + member.getName());
            return true;
        } else {
            System.out.println("Το περιοδικό '" + getTitle() + "' δεν είναι αυτή τη στιγμή διαθέσιμο.");
            return false;
        }
    }

    @Override
    public boolean returnItem() {
        setAvailable(true);
        System.out.println("Το περιοδικό '" + getTitle() + "' επιστράφηκε επιτυχώς!");
        return true;
    }
}
