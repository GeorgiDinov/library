package com.georgidinov.domain.record;

import com.georgidinov.domain.book.Book;
import com.georgidinov.domain.person.Person;

import java.time.LocalDate;

import static com.georgidinov.util.MyDateFormatter.getDateString;
import static com.georgidinov.util.MyMessages.*;

public class Record {

    public static final int REGULAR_BORROW_PERIOD_IN_DAYS = 14;
    public static final int MAX_BORROW_PERIOD_IN_DAYS = 28;

    private static int instanceCounter = 0;
    private int id;

    private int bookId;
    private int readerId;
    private LocalDate issuedDate;
    private LocalDate dueDate;
    private LocalDate maxPostponeDate;

    public Record(Book book, Person person) {
        this.id = ++instanceCounter;
        this.bookId = book.getId();
        this.readerId = person.getId();
        this.issuedDate = LocalDate.now();
        this.dueDate = issuedDate.plusDays(REGULAR_BORROW_PERIOD_IN_DAYS);
        this.maxPostponeDate = issuedDate.plusDays(MAX_BORROW_PERIOD_IN_DAYS);
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

    public void postpone(int days) {
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
        if (!(object instanceof Record)) {
            return false;
        }
        Record record = (Record) object;
        return id == record.id;
    }

    @Override
    public int hashCode() {
        return id + 17;
    }

}
