package book.bookmanage.service;

import book.bookmanage.entity.Book;

import java.util.List;

public interface BookManage {

    List<Book> queryBooks(String name);

    List<Book> queryAll();

    Book lendBook(int bookid);

    Book backBook(int bookid);

    Book addBook(Book book);

    void deleteBook(int bookid);

}
