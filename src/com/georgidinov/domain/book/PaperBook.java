package com.georgidinov.domain.book;

import com.georgidinov.domain.person.BookAuthor;

import java.util.Set;

import static com.georgidinov.util.MyMessages.INVALID_PARAMETER;
import static com.georgidinov.util.MyMessages.QUANTITY;
import static com.georgidinov.util.MyMessages.SPACE;

public class PaperBook extends Book {

    private int quantity;

    public PaperBook(String title, String isbn, Set<BookAuthor> authors,
                     String summary, Genre genre, int quantity) {
        super(title, isbn, authors, summary, genre);
        this.quantity = validateQuantity(quantity);
    }

    //getters
    public int getQuantity() {
        return this.quantity;
    }

    //validations
    private int validateQuantity(int quantity) {
        if (quantity >= 0) {
            return quantity;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + QUANTITY);
    }
}
