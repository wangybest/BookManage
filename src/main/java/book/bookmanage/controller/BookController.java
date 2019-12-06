package book.bookmanage.controller;

import book.bookmanage.entity.Book;
import book.bookmanage.service.BookManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "books")
public class BookController {

    @Autowired
    BookManage bookManage;

    public BookController(BookManage bookManage) {
        this.bookManage = bookManage;
    }

    @GetMapping("/{name}")
    public List<Book> queryBooksByName(@PathVariable String name) {
        return bookManage.queryBooks(name);
    }

    @GetMapping
    public List<Book> queryAllBooks() {
        return bookManage.queryAll();
    }

    @PutMapping("lend/{id}")
    public ResponseEntity<Book> lendBook(@PathVariable int id) {
        Book lendBook = bookManage.lendBook(id);
        return ResponseEntity.ok(lendBook);
    }

    @PutMapping("back/{id}")
    public ResponseEntity<Book> backBook(@PathVariable int id) {
        Book backBook = bookManage.backBook(id);
        return ResponseEntity.ok(backBook);
    }

    @PostMapping("add")
    public ResponseEntity<Book> addBook(@ModelAttribute Book book) {
        Book addBook = bookManage.addBook(book);
        return ResponseEntity.ok(addBook);
    }

    @DeleteMapping("delete/{id}")
    public void deleteBook(@PathVariable int id) {
        bookManage.deleteBook(id);
    }
}