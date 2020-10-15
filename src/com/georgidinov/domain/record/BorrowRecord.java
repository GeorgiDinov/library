package com.georgidinov.domain.record;

import com.georgidinov.domain.book.Book;
import com.georgidinov.domain.person.Person;

import java.time.LocalDate;

import static com.georgidinov.util.MyDateFormatter.getDateString;
import static com.georgidinov.util.MyPunctuation.COMA;
import static com.georgidinov.util.MyPunctuation.SPACE;

public class BorrowRecord {

    private static final String POSTPONE_REQUEST = "Postpone Request";
    private static final String GRANTED = "Granted";
    private static final String DENIED = "Denied";
    public static final String NEW = "New";
    public static final String DUE_DATE = "Due Date";
    public static final String IS = "Is";
    private static final int REGULAR_BORROW_PERIOD_IN_DAYS = 14;
    private static final int MAX_BORROW_PERIOD_IN_DAYS = 28;

    private static int instanceCounter = 0;
    private final int id;

    private int bookId;
    private int readerId;
    private LocalDate issuedDate;
    private LocalDate dueDate;
    private LocalDate maxPostponeDate;

    public BorrowRecord(Book book, Person person) {
        this.bookId = book.getId();
        this.readerId = person.getId();
        this.issuedDate = LocalDate.now();
        this.dueDate = issuedDate.plusDays(REGULAR_BORROW_PERIOD_IN_DAYS);
        this.maxPostponeDate = issuedDate.plusDays(MAX_BORROW_PERIOD_IN_DAYS);
        this.id = ++instanceCounter;
    }

    public int getId() {
        return id;
    }

    public int getBookId() {
        return bookId;
    }

    public int getReaderId() {
        return readerId;
    }

    public LocalDate getIssuedDate() {
        return this.issuedDate;
    }

    public String getIssuedDateString() {
        return getDateString(this.issuedDate);
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public String getDueDateString() {
        return getDateString(this.dueDate);
    }

    public void postponeRequest(int days) {
        if (this.postponeIsPossible(days)) {
            this.dueDate = this.dueDate.plusDays(days);
            System.out.println(POSTPONE_REQUEST + SPACE + GRANTED + COMA +
                    NEW + DUE_DATE + IS + this.getDueDateString());
        } else {
            System.out.println(POSTPONE_REQUEST + SPACE + DENIED + COMA +
                    DUE_DATE + IS + this.getDueDateString());
        }
    }

    private boolean postponeIsPossible(int days) {
        return (days > 0) &&
                (this.dueDate.plusDays(days).isBefore(this.maxPostponeDate) ||
                        this.dueDate.plusDays(days).isEqual(this.maxPostponeDate));
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof BorrowRecord)) {
            return false;
        }
        BorrowRecord borrowRecord = (BorrowRecord) object;
        return id == borrowRecord.id;
    }

    @Override
    public int hashCode() {
        return id + 17;
    }

}
