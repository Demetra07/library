package gr.university.library.model;

// Η DigitalBook είναι παιδί της Book (η οποία είναι παιδί της LibraryItem)
public class DigitalBook extends Book {

    private double fileSize; // Μέγεθος αρχείου
    private String fileFormat; // Μορφή αρχείου (π.χ. "PDF")

    // Constructor
    public DigitalBook(String id, String title, int publicationYear, String author, String isbn, double fileSize, String fileFormat) {
        // Το super αξιοποιεί τον Constructor της Book, άρα περνάει και τον συγγραφέα και το ISBN!
        super(id, title, publicationYear, author, isbn);
        this.fileSize = fileSize;
        this.fileFormat = fileFormat;
    }

    // Getters & Setters
    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    @Override
    public String getDescription() {
        return "Ψηφιακό Βιβλίο: '" + getTitle() + "' του " + getAuthor() + " (Μορφή: " + getFileFormat() + ", " + getFileSize() + "MB)";
    }
    
}
