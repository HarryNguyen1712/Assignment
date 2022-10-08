package Long.JPLLA101.Dao;

import Long.JPLLA101.entities.Publications;

import java.util.List;

public interface GeneralDaoInterface {
    void displayByPublicationYearAndPublisher(List<Publications> publicationsList);
}
