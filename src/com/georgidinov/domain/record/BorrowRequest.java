package com.georgidinov.domain.record;

import com.georgidinov.domain.book.Book;
import com.georgidinov.domain.person.Person;

import java.time.LocalDate;

import static com.georgidinov.util.MyDateFormatter.getDateString;

public class BorrowRequest {


    public static final int ACTIVE_RESERVATION_PERIOD_IN_DAYS = 3;

    private static int instanceCounter = 0;
    private int id;


    private int bookId;
    private int readerId;
    private LocalDate reservationDueDate;
    private boolean isActive;

    public BorrowRequest(Book book, Person person) {
        this.id = ++instanceCounter;
        this.bookId = book.getId();
        this.readerId = person.getId();
        this.reservationDueDate = LocalDate.now().plusDays(ACTIVE_RESERVATION_PERIOD_IN_DAYS);
        this.isActive = true;
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

    public LocalDate getReservationDueDate() {
        return reservationDueDate;
    }

    public String getReservationDueDateString() {
        return getDateString(this.reservationDueDate);
    }

    public boolean isActive() {
        return isActive;
    }

    public void changeState() {
        if (this.reservationDueDate.isEqual(LocalDate.now())) {
            this.isActive = false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BorrowRequest)) {
            return false;
        }
        BorrowRequest that = (BorrowRequest) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id + 31;
    }
}
