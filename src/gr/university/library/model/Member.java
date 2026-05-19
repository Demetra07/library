package gr.university.library.model;

public abstract class Member {
    //Encapsulation για να τα βλέπει μόνο η ιδια η κλάση
    private String id;
    private String name;
    private String email;
    private int maxLoans;

    //Constructor για να αρχικοποοιείται κάθε αντικείμενο πριν την δημιουργία του
    public Member(String id, String name, String email, int maxLoans) {
        this.id = id;
        this.name = name;
        setEmail(email); // Καλούμε setter για να γίνει ο έλεγχος @ αυτόματα
        this.maxLoans = maxLoans;
}
//Πρόσβαση σε πεδία μέσω Getters-Setters
public String getId() {
    return id;
}

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

//έλεγχος εγκυρότηατσ για να περιεχεται πάντα το @ στο μαιλ
public void setEmail(String email) {
    if (email != null && email.contains("@")) {
        this.email = email;
    } else {
        System.out.println("Σφάλμα: Μη έγκυρη μορφή email (λείπει το @).");
        this.email = "invalid@university.gr"; // Μια προσωρινή τιμή ασφαλείας
    }
}

    public int getMaxLoans() {
        return maxLoans;
    }

    public void setMaxLoans(int maxLoans) {
        this.maxLoans = maxLoans;
    }
}