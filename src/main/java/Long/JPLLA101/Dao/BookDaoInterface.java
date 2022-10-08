package Long.JPLLA101.Dao;

import Long.JPLLA101.entities.Book;
import Long.JPLLA101.entities.Publications;

import java.util.List;

public interface BookDaoInterface {
    void add(Book book, List<Publications> publicationsList);

    void addAuthor(Book book);

    Book searchBookByISBN(String ISBN,List<Publications>publicationsList);
    List<Book> searchBookByAuthor(String Author,List<Publications>publicationsList);
    List<Book> searchBookByPublisher(String Publisher,List<Publications>publicationsList);

    List<Book> searchBookByISBNAuthorPublisher(String criteria,List<Publications>publicationsList);
}
