package com.georgidinov.domain.book;

import com.georgidinov.domain.person.BookAuthor;

import java.util.Set;

import static com.georgidinov.util.MyMessages.DOWNLOAD_LINK;
import static com.georgidinov.util.MyMessages.INVALID_PARAMETER;
import static com.georgidinov.util.MyMessages.PREVIEW_LINK;
import static com.georgidinov.util.MyMessages.SPACE;
import static com.georgidinov.util.Validator.isValidString;

public class EDownloadableBook extends Book implements EReadable, EDownloadable {

    private String linkToPreview;
    private String linkToDownload;

    protected EDownloadableBook(String title, String isbn, Set<BookAuthor> authors,
                                String summary, Genre genre, String linkToPreview, String linkToDownload) {
        super(title, isbn, authors, summary, genre);
        this.linkToDownload = this.validateDownloadLink(linkToDownload);
        this.linkToPreview = this.validatePreviewLink(linkToPreview);
    }

    @Override
    public String getLinkToPreview() {
        return null;
    }

    @Override
    public String getLinkToDownload() {
        return null;
    }

    //validations
    private String validateDownloadLink(String downloadLink) {
        if (isValidString(downloadLink)) {
            return downloadLink;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + DOWNLOAD_LINK);
    }

    private String validatePreviewLink(String previewLink) {
        if (isValidString(previewLink)) {
            return previewLink;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + PREVIEW_LINK);
    }
}
