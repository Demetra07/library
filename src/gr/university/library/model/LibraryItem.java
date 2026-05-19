package gr.university.library.model;

import gr.university.library.contracts.Borrowable;

public abstract class LibraryItem implements Borrowable {

    // 1. Private πεδία (Encapsulation)
    private String id;              // Κωδικός
    private String title;           // Τίτλος
    private int publicationYear;    // Έτος έκδοσης
    private boolean available;      // Διαθεσιμότητα

    // 2. Constructor
    public LibraryItem(String id, String title, int publicationYear) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.available = true; //Όταν ένα νέο αντικείμενο μπαίνει στη βιβλιοθήκη είναι διαθέσιμο στην αρχή
    }

    // 3. Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    //Σύνδεση με το Interface Borrowable που χρειαζεται την μεθοδο is Available()
    @Override
    public boolean isAvailable() {
        return available;
    }
}
