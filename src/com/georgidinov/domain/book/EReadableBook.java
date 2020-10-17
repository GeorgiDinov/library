package com.georgidinov.domain.book;

import com.georgidinov.domain.person.BookAuthor;

import java.util.Set;

import static com.georgidinov.util.Validator.validateStringField;

public class EReadableBook extends Book implements EReadable {

    private String previewLink;

    public EReadableBook(String title, String isbn, Set<BookAuthor> authors,
                         String summary, Genre genre, String previewLink) {
        super(title, isbn, authors, summary, genre);
        this.previewLink = validateStringField(previewLink);
    }

    @Override
    public String getLinkToPreview() {
        return previewLink;
    }

}
