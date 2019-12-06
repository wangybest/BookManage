package book.bookmanage.config;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoEnoughResourceException extends RuntimeException {

    private int bookId;

    private Object data;

    public NoEnoughResourceException(String message,int bookId) {
        super(message);
        this.bookId = bookId;
    }

    public NoEnoughResourceException(int bookId,Object data) {
        this.data = data;
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public Object getData() {
        return data;
    }
}
