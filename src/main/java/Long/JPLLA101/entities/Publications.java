package Long.JPLLA101.entities;

import java.time.LocalDate;

public abstract class Publications {
    private int publicationYear;
    private String publisher;
    private LocalDate publicationDate;

    public Publications() {
    }

    public Publications(int publicationYear, String publisher, LocalDate publicationDate) {
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

     public abstract void display();
}
