package gr.university.library.contracts;

import gr.university.library.model.Member;

public interface Borrowable {
    boolean borrowTo(Member member);
    boolean returnItem();
    boolean isAvailable();
}
