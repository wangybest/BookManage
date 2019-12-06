package book.bookmanage.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findByName(String name);

    @Modifying
    @Query("update Book b  set number=(number-1) where b.bookId=?1")
    void lendBookById(int bookid);

    @Modifying
    @Query("update Book b set number=(number+1) where b.bookId=?1")
    void backBookById(int bookid);



}
