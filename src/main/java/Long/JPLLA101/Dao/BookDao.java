package Long.JPLLA101.Dao;

import Long.JPLLA101.entities.Book;
import Long.JPLLA101.entities.Publications;
import validate.Validate;

import java.time.LocalDate;
import java.util.*;

public class BookDao implements BookDaoInterface{
    Scanner scanner= new Scanner(System.in);

    @Override
    public void add(Book book, List<Publications> publicationsList) {
        System.out.println("Input publication year:");
        int publicationYear= Integer.parseInt(scanner.nextLine());
        System.out.println("Input publisher:");
        String publisher= scanner.nextLine();
        System.out.println("Input publication date:");
        LocalDate publicationDate = LocalDate.parse(scanner.nextLine().formatted());
        do{
            System.out.println("Input ISBN:");
            String isbn= scanner.nextLine();
            if(Validate.validateISBN(isbn)){
                break;
            }
        }
        while (true);
        System.out.println("Input ISBN:");
        String isbn= scanner.nextLine();
        boolean authorBo=true;
        Set<String> authorSet= new HashSet<>();
        while(authorBo){
            System.out.println("Input author");
            String author= scanner.nextLine();
            authorSet.add(author);
            System.out.println("do you want to input more?(Y/N)");
            String s= scanner.nextLine();
            if(!s.equalsIgnoreCase("y")&& !s.equalsIgnoreCase("n")){
                while(true){
                    System.out.println("wrong(Y/N)");
                    String temp=scanner.nextLine();
                    if(temp.equalsIgnoreCase("n")||temp.equalsIgnoreCase("y")){
                        s=temp;
                        break;
                    }
                }
                }
            if(s.equalsIgnoreCase("n")){
                authorBo=false;
                }

        }


        System.out.println("Input publication place:");
        String publicationPlace= scanner.nextLine();
        book.setPublisher(publisher);
        book.setPublicationDate(publicationDate);
        book.setPublicationYear(publicationYear);
        book.setAuthor(authorSet);
        book.setIsbn(isbn);
        book.setPublicationPlace(publicationPlace);
        publicationsList.add(book);
    }

    @Override
    public void addAuthor(Book book) {
        boolean authorBo=true;
        Set<String> authorSet= book.getAuthor();
        boolean inner= false;
        while(authorBo){
            System.out.println("Input author");
            String author= scanner.nextLine();
            boolean test=false;
            if(!book.getAuthor().isEmpty()){
                for(String author1: book.getAuthor()){
                    if (author1.equalsIgnoreCase(author)) {
                        test = true;
                        break;
                    }
                }
            }

            if(test){
                System.out.println("Author existed");
                continue;
            }
            else {
                authorSet.add(author);
                System.out.println("Add successfully");
            }

            System.out.println("do you want to input more?(Y/N)");
            String s= scanner.nextLine();
            if(!s.equalsIgnoreCase("y")&& !s.equalsIgnoreCase("n")){
                while(true){
                    System.out.println("wrong(Y/N)");
                    String temp=scanner.nextLine();
                    if(temp.equalsIgnoreCase("n")||temp.equalsIgnoreCase("y")){
                        s=temp;
                        break;
                    }
                }
            }
            if(s.equalsIgnoreCase("n")){
                authorBo=false;
            }

        }
        book.setAuthor(authorSet);

    }

    @Override
    public Book searchBookByISBN(String ISBN,List<Publications>publicationsList) {

        for(Publications publications: publicationsList){
            if(publications instanceof Book book){
                if(book.getIsbn().equalsIgnoreCase(ISBN)){
                    return book;
                }
            }
        }
        return null;
    }

    @Override
    public List<Book> searchBookByAuthor(String author,List<Publications>publicationsList) {
        List<Book> bookList=  new ArrayList<>();
        for(Publications publications: publicationsList){
            if(publications instanceof Book book){
                for(String s: book.getAuthor()){
                    if(s.equalsIgnoreCase(author)){
                        bookList.add(book);
                    }
                }
            }
        }


        return bookList;
    }

    @Override
    public List<Book> searchBookByPublisher(String Publisher,List<Publications>publicationsList) {
        List<Book> bookList=  new ArrayList<>();
        for(Publications publications: publicationsList){
            if(publications instanceof Book book){
                if(book.getPublisher().equalsIgnoreCase(Publisher)){
                    bookList.add(book);
                };
            }
        }
        return bookList;
    }

    @Override
    public List<Book> searchBookByISBNAuthorPublisher(String criteria, List<Publications> publicationsList) {
        List<Book> bookList = new ArrayList<>();
        try{
            bookList.add(searchBookByISBN(criteria,publicationsList));
            bookList.addAll(searchBookByPublisher(criteria,publicationsList));
            bookList.addAll(searchBookByAuthor(criteria,publicationsList));
            for(Book book: bookList){
                book.display();
                System.out.println("------------------------------------------");
            }
        }
        catch (NullPointerException e){
            System.out.println("we dont have that book");
        }
        return null;
    }
}
