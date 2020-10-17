package com.georgidinov.domain.book;

import com.georgidinov.domain.person.BookAuthor;

import java.util.Set;

import static com.georgidinov.util.Validator.validateStringField;

public class EDownloadableBook extends Book implements EReadable, EDownloadable {

    private String linkToPreview;
    private String linkToDownload;

    public EDownloadableBook(String title, String isbn, Set<BookAuthor> authors,
                             String summary, Genre genre, String linkToPreview, String linkToDownload) {
        super(title, isbn, authors, summary, genre);
        this.linkToDownload = validateStringField(linkToDownload);
        this.linkToPreview = validateStringField(linkToPreview);
    }

    @Override
    public String getLinkToPreview() {
        return linkToPreview;
    }

    @Override
    public String getLinkToDownload() {
        return linkToDownload;
    }

}
