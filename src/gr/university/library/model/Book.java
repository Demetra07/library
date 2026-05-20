package gr.university.library.model;

// Με το extends: η Book είναι "παιδί" της LibraryItem
public class Book extends LibraryItem {

    // 1. Μόνο τα νέα, δικά της πεδία!
    private String author;
    private String isbn;

    // 2. Constructor
    public Book(String id, String title, int publicationYear, String author, String isbn) {
        // Η λέξη super() αξιοποιεί τον Constructor του "γονιού" (LibraryItem)
        // για να φτιάξει κατευθείαν id, title και έτος
        super(id, title, publicationYear);

        // Αρχικοποιούμε τα δικά της πεδία
        this.author = author;
        this.isbn = isbn;
    }

    // 3. Getters & Setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // 4. Υλοποίηση των μεθόδων του Interface Borrowable
    @Override
    public boolean borrowTo(Member member) {
        if (isAvailable()) {
            setAvailable(false);
            System.out.println("Το βιβλίο '" + getTitle() + "' δανείστηκε στο μέλος: " + member.getName());
            return true;
        } else {
            System.out.println("Το βιβλίο '" + getTitle() + "' δεν είναι αυτή τη στιγμή διαθέσιμο.");
            return false;
        }
    }

    @Override
    public boolean returnItem() {
        setAvailable(true);
        System.out.println("Το βιβλίο '" + getTitle() + "' επιστράφηκε επιτυχώς!");
        return true;
    }
    @Override
    public String getDescription() {
        return "Βιβλίο: '" + getTitle() + "' του " + getAuthor() + " (ISBN: " + getIsbn() + ")";
    }
}