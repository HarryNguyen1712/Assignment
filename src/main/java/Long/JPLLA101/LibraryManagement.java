package Long.JPLLA101;

import AssignmentPart2.entities.Candidate;
import AssignmentPart2.entities.Experience;
import AssignmentPart2.entities.Fresher;
import AssignmentPart2.entities.Intern;
import Long.JPLLA101.Dao.BookDao;
import Long.JPLLA101.Dao.GeneralDao;
import Long.JPLLA101.Dao.MagazineDao;
import Long.JPLLA101.entities.Book;
import Long.JPLLA101.entities.Magazine;
import Long.JPLLA101.entities.Publications;
import validate.Validate;

import java.time.LocalDate;
import java.util.*;

public class LibraryManagement {
    static BookDao bookDao= new BookDao();

    static MagazineDao magazineDao = new MagazineDao();
    static GeneralDao generalDao= new GeneralDao();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
      List<Publications> bookList= new ArrayList<>();
      bookList.add(new Book(2022,"huy", LocalDate.parse("2022-12-12"),"123-456-789-789",new HashSet<>(),"Viet Nam"));
        bookList.add(new Book(2022,"huy", LocalDate.parse("2022-12-24"),"123-456-789-444",new HashSet<>(),"Da Nang"));
        bookList.add(new Book(2022,"huy", LocalDate.parse("2020-12-22"),"777-456-254-789",new HashSet<>(),"Viet Nam"));
        bookList.add(new Magazine(2022,"huy", LocalDate.parse("2022-12-12"),"Bao Anh",1,2));
        bookList.add(new Magazine(2023,"huy", LocalDate.parse("2000-02-02"),"Bao Anh",2,3));

        boolean start = true;
        while (start) {
            System.out.println("Choose what function you want to process:");
            System.out.println("1.Add Book ");
            System.out.println("2.Add Magazine");
            System.out.println("3.Display books and maganizes");
            System.out.println("4.Add author to book");
            System.out.println("5.Display top 10 of magazines by volume");
            System.out.println(".Search book by (isbn, author, publisher)");
            System.out.println("7.Exit ");
            System.out.println("_________________________");
            sc=new Scanner(System.in);
            int choice = Integer.parseInt(sc.nextLine());
            boolean inner = true;
            while (inner) {
                switch (choice) {
                    case 1 -> {
                        inner = false;
                        Book book = new Book();
                        bookDao.add(book, bookList);
                        System.out.println("\n");
                        System.out.println("_________________________");
                    }
                    case 2 -> {
                        inner = false;
                        Magazine magazine = new Magazine();
                        magazineDao.add(magazine, bookList);
                        System.out.println("_________________________");
                    }
                    case 3 -> {
                        inner = false;
                        generalDao.displayByPublicationYearAndPublisher(bookList);
                        System.out.println("\n");
                        System.out.println("_________________________");
                    }
                    case 4 -> {
                            System.out.println("please input ISBN");
                            String ISBN=sc.nextLine();
                            Book book= bookDao.searchBookByISBN(ISBN,bookList);
                            bookDao.addAuthor(book);

                            for(Publications ca: bookList){
                                if(ca instanceof Book book1){
                                    if(book1.getIsbn().equalsIgnoreCase(ISBN)){

                                        System.out.println(Arrays.toString(book1.getAuthor().toArray()));
                                    }
                                }
                            }
                        inner = false;

                        System.out.println("-----------------------");
                    }
                    case 5 -> {
                        magazineDao.top10MagazineLargestVolume(bookList);
                        inner = false;
                    }
                    case 6 -> {
                        System.out.println("input your criteria");
                        String criteria= sc.nextLine();
                        bookDao.searchBookByISBNAuthorPublisher(criteria,bookList);
                        inner = false;
                    }
                    case 7 -> {
                        inner = false;
                        start = false;
                    }
                    default -> {
                        System.out.println("_________________________");
                        System.out.println("Wrong choice");
                        System.out.println("Try again please");
                        choice = Integer.parseInt(sc.nextLine());
                        System.out.println("_________________________");
                    }
                }
            }
        }
    }
}
