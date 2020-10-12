package com.georgidinov.domain.book;

import com.georgidinov.domain.person.BookAuthor;

import java.util.Set;

import static com.georgidinov.util.MyMessages.INVALID_PARAMETER;
import static com.georgidinov.util.MyMessages.PREVIEW_LINK;
import static com.georgidinov.util.MyMessages.SPACE;
import static com.georgidinov.util.Validator.isValidString;

public class EReadableBook extends Book implements EReadable {

    private String previewLink;

    public EReadableBook(String title, String isbn, Set<BookAuthor> authors,
                         String summary, Genre genre, String previewLink) {
        super(title, isbn, authors, summary, genre);
        this.previewLink = this.validatePreviewLink(previewLink);
    }

    //getters
    @Override
    public String getLinkToPreview() {
        return previewLink;
    }

    //validations
    private String validatePreviewLink(String previewLink) {
        if (isValidString(previewLink)) {
            return previewLink;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + PREVIEW_LINK);
    }

}
