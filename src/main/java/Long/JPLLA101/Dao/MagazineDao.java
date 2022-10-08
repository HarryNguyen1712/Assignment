package Long.JPLLA101.Dao;

import Long.JPLLA101.entities.Magazine;
import Long.JPLLA101.entities.Publications;
import validate.Validate;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MagazineDao implements MagazineDaoInterface{

    Scanner scanner = new Scanner(System.in);
    @Override
    public void add(Magazine magazine, List<Publications> publicationsList) {
        System.out.println("Input publication year:");
        int publicationYear= Integer.parseInt(scanner.nextLine());

        System.out.println("Input publisher:");
        String publisher= scanner.nextLine();

        System.out.println("Input publication date:");
        LocalDate publicationDate = LocalDate.parse(scanner.nextLine().formatted());

        System.out.println("Input author:");
        String author= scanner.nextLine();

        System.out.println("Input volumn");
        int volumn= Integer.parseInt(scanner.nextLine());

        System.out.println("Input edition:");
        int edition= Integer.parseInt(scanner.nextLine());

        magazine.setPublisher(publisher);
        magazine.setPublicationDate(publicationDate);
        magazine.setPublicationYear(publicationYear);
        magazine.setAuthor(author);
        magazine.setEdition(edition);
        magazine.setVolumn(volumn);
        publicationsList.add(magazine);
    }

    @Override
    public void top10MagazineLargestVolume(List<Publications> publicationsList) {
        List<Magazine> magazines= publicationsList
                .stream().filter(publications -> publications instanceof Magazine)
                .map(Magazine.class::cast)
                .sorted(Comparator.comparingInt(Magazine::getVolumn))
                .limit(10).toList();
        magazines.forEach(magazine -> {magazine.display();System.out.println("----------------------");});

    }
}
