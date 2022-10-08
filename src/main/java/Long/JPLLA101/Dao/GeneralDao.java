package Long.JPLLA101.Dao;

import Long.JPLLA101.entities.Book;
import Long.JPLLA101.entities.Magazine;
import Long.JPLLA101.entities.Publications;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GeneralDao implements GeneralDaoInterface{


    @Override
    public void displayByPublicationYearAndPublisher(List<Publications> publicationsList) {
        Set<Publications> publicationsList1 = new HashSet<>();
        for(Publications publications1: publicationsList){

            publicationsList1.remove(publications1);
            Set<Publications> publicationsSet=publicationsList.stream()
                    .filter(publications -> (publications1.getPublisher().equalsIgnoreCase(publications.getPublisher())&&publications1.getPublicationYear()==publications.getPublicationYear()&& publications1!=publications)).collect(Collectors.toSet());
        if(!publicationsSet.isEmpty()){
            publicationsList1.add(publications1);
            publicationsList1.addAll(publicationsSet);
        }
        }
        publicationsList1.forEach(publications -> {
            if (publications instanceof Book b){
                b.display();


            }
            else if(publications instanceof Magazine magazine)
            {
                magazine.display();

            }
            System.out.println("----------------------------");
            });


    }
}
