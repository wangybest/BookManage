package book.bookmanage.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage<T> {

    private String message;

    private T data;

    public ErrorMessage(String message) {
        this.message = message;
    }
}
