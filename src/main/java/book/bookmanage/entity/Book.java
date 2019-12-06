package book.bookmanage.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid")
    private Integer bookId;

    private String name;

    private String author;

    private int number;

    public static Book DefaultNoBook(){
        return new Book(null, "不存在该书籍", "不存在该作者", -9999);
    }

}
