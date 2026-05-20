package gr.university.library.contracts;

import gr.university.library.model.LibraryItem;
import gr.university.library.model.Member;

public interface Searchable {
    // Ψάχνει ένα αντικείμενο βάσει του κωδικού του
    LibraryItem findItemByCode(String code);

    // Ψάχνει ένα μέλος βάσει του ID του
    Member findMemberById(String id);
}
