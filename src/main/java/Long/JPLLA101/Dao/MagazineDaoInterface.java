package Long.JPLLA101.Dao;

import Long.JPLLA101.entities.Magazine;
import Long.JPLLA101.entities.Publications;

import java.util.List;

public interface MagazineDaoInterface {
    void add(Magazine magazine, List<Publications> publicationsList);
    void top10MagazineLargestVolume(List<Publications> publicationsList);
}
