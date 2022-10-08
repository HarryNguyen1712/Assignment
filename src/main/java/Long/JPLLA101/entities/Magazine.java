package Long.JPLLA101.entities;

import java.time.LocalDate;
import java.util.Comparator;

public class Magazine extends  Publications implements Comparator<Magazine> {
    private String author;
    private int volumn;
    private int edition;

    public Magazine() {
    }

    public Magazine(int publicationYear, String publisher, LocalDate publicationDate, String author, int volumn, int edition) {
        super(publicationYear, publisher, publicationDate);
        this.author = author;
        this.volumn = volumn;
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getVolumn() {
        return volumn;
    }

    public void setVolumn(int volume) {
        this.volumn = volume;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public void display() {
        System.out.println("Publication Yaer:"+ this.getPublicationYear()+"\nPublisher:"+this.getPublisher()+"\nPublication Date:"+this.getPublicationDate()+"\nAthor:"+this.getAuthor()+"\nVolumn"+this.getVolumn()+"\nEdition"+this.getEdition());
    }

    @Override
    public int compare(Magazine o1, Magazine o2) {
        return Integer.compare(o1.getVolumn(),o2.getVolumn());
    }
}
