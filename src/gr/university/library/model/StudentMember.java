package gr.university.library.model;

// Η StudentMember κληρονομεί από την abstract κλάση Member
public class StudentMember extends Member {

    private String studentId; // Αριθμός Μητρώου
    private String department; // Τμήμα

    // Constructor
    public StudentMember(String id, String name, String email, int maxLoans, String studentId, String department) {
        // Καλούμε τον constructor της Member για να φτιάξει τα βασικά στοιχεία
        super(id, name, email, maxLoans);

        // Αρχικοποίηση
        this.studentId = studentId;
        this.department = department;
    }

    // Getters & Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
