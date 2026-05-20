package gr.university.library.model;

import gr.university.library.contracts.Borrowable;

public abstract class LibraryItem implements Borrowable {

    // 1. Private πεδία (Encapsulation)
    private static int totalItems=0;
    private String id;              // Κωδικός
    private String title;           // Τίτλος
    private int publicationYear;    // Έτος έκδοσης
    private boolean available;      // Διαθεσιμότητα
    protected int maxLoanDays=14;
    // 2. Constructor
    public LibraryItem(String id, String title, int publicationYear) {
        setId(id);
        setTitle(title);
        setPublicationYear(publicationYear);
        this.available = true; //Όταν ένα νέο αντικείμενο μπαίνει στη βιβλιοθήκη είναι διαθέσιμο στην αρχή
        totalItems++; //αύξηση μετρητή με την δημιουργία αντικειμένου
    }
    // Έλεγχοι Εγκυρότητας
    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            System.out.println("Σφάλμα: Ο κωδικός (id) δεν μπορεί να είναι κενός.");
            this.id = "UNKNOWN";
        }
    }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Σφάλμα: Ο τίτλος δεν μπορεί να είναι κενός.");
            this.title = "Untitled";
        }
    }

    //package-private modifier (χωρίς public/private) ---
    boolean isValidYear(int year) {
        // Το έτος πρέπει να είναι θετικό και όχι μεγαλύτερο από το τρέχον (2026)
        return year > 0 && year <= 2026;
    }

    public void setPublicationYear(int publicationYear) {
        if (isValidYear(publicationYear)) {
            this.publicationYear = publicationYear;
        } else {
            System.out.println("Σφάλμα: Μη έγκυρο έτος έκδοσης (" + publicationYear + "). Ορίστηκε το τρέχον.");
            this.publicationYear = 2026;
        }
    }

    //abstract μέθοδος για πολυμορφισμό
    public abstract String getDescription();

    public static int getTotalItems() { return totalItems; }
    public String getId() { return id; }
    public String getTitle() { return title; }
    public int getPublicationYear() { return publicationYear; }

    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public boolean isAvailable() { return available; }
}
