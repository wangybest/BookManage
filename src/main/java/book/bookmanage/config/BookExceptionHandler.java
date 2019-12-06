package book.bookmanage.config;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestControllerAdvice
public class BookExceptionHandler {

    @ExceptionHandler(value = NoEnoughResourceException.class)
    public ResponseEntity defaultErrorHandler(HttpServletRequest req, NoEnoughResourceException e)  {
        return ResponseEntity.ok(new ErrorMessage<>(
                String.format("你要借的ID为%s书已经被借完了！你可以看看DATA里的其他书籍~", e.getBookId()),
                e.getData()));

    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity argumentErrorHandler(HttpServletRequest req,NullPointerException e){
        return ResponseEntity.ok(new ErrorMessage<>(
                new String("不存在该书籍")
                )
        );
    }
}
