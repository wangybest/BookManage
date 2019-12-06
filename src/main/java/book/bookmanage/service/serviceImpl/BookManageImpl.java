package book.bookmanage.service.serviceImpl;

import book.bookmanage.config.NoEnoughResourceException;
import book.bookmanage.entity.Book;
import book.bookmanage.entity.BookRepository;
import book.bookmanage.service.BookManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookManageImpl implements BookManage {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> queryBooks(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public List<Book> queryAll() {
        return  bookRepository.findAll();
    }

    @Override
    public Book lendBook(int bookid) {
        Book book = bookRepository.findById(bookid).orElse(Book.DefaultNoBook());
        if(book.getNumber() == 0){
            List<Book> books = bookRepository.findAll();
            throw new NoEnoughResourceException(bookid,books);
        } else if (book.getNumber() < 0) {
            return book;
        } else {
            bookRepository.lendBookById(bookid);
            return book;
        }
    }

    @Override
    public Book backBook(int bookid) {
        if (bookRepository.existsById(bookid)){
           Book book=bookRepository.findById(bookid).get();
            book.setNumber(book.getNumber()+1);
             return bookRepository.save(book);
        }else {
            throw new NullPointerException();
        }
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(int bookid) {
        if (bookRepository.existsById(bookid)){
            bookRepository.deleteById(bookid);
        }else {
            throw  new NullPointerException();
        }
    }
}
