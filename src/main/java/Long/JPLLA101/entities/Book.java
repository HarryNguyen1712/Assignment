package Long.JPLLA101.entities;

import java.time.LocalDate;
import java.util.Set;

public class Book extends Publications {
    private String isbn;
    private Set<String>author;
    private String publicationPlace;

    public Book() {
    }

    public Book(int publicationYear, String publisher, LocalDate publicationDate, String isbn, Set<String> author, String publicationPlace) {
        super(publicationYear, publisher, publicationDate);
        this.isbn = isbn;
        this.author = author;
        this.publicationPlace = publicationPlace;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<String> getAuthor() {
        return author;
    }

    public void setAuthor(Set<String> author) {
        this.author = author;
    }

    public String getPublicationPlace() {
        return publicationPlace;
    }

    public void setPublicationPlace(String publicationPlace) {
        this.publicationPlace = publicationPlace;
    }

    @Override
     public void display() {
        System.out.println("Publication Yaer:"+ this.getPublicationYear()+"\nPublisher:"+this.getPublisher()+"\nPublication Date:"+this.getPublicationDate()+"\nISBN:"+this.getPublicationDate()+"\nAuthor:"+this.getAuthor()+"\nPublication Place:"+this.getPublicationPlace());
    }
}
