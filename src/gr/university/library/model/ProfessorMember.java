package gr.university.library.model;

public class ProfessorMember extends Member {

    private String subject; // Γνωστικό αντικείμενο καθηγητή

    // Constructor
    public ProfessorMember(String id, String name, String email, int maxLoans, String subject) {
        super(id, name, email, maxLoans);
        this.subject = subject;
    }

    // Getters & Setters
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
