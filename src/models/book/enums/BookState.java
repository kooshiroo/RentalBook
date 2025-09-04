package models.book.enums;

import models.book.Book;

public enum BookState {
    AVAILABLE("貸出可能"),
    CHECKED_OUT("貸出中"),
    RESERVED("予約"),
    BANNED("廃止");

    private String label;

    BookState(String label) {
        this.label = label;
    }
}
