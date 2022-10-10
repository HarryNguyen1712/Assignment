package AssignmentPart2.Controller;

import AssignmentPart2.Configuration.DBconfig;
import AssignmentPart2.Dao.CandidateDAO;
import AssignmentPart2.entities.Candidate;
import AssignmentPart2.entities.Experience;
import AssignmentPart2.entities.Fresher;
import AssignmentPart2.entities.Intern;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Get controller.
 */
public class GetController {
    DBconfig dBconfig= new DBconfig();
    CandidateDAO candidateDAO=new CandidateDAO();

    /**
     * lấy ra tất cả candidate.
     *
     * @return the all candidate
     * @throws SQLServerException the sql server exception
     */
    public List<Candidate> getAllCandidate() throws SQLServerException {
        return candidateDAO.getAllCandidate();
    }

    /**
     * lấy ra chuỗi các tên candidate bằng String.
     *
     * @return the all name
     * @throws SQLException the sql exception
     */
    public String getAllName() throws SQLException {
        return candidateDAO.getAllName();
    }

    /**
     * lấy ra chuỗi các tên candidate trong database bằng StringBuilder.
     *
     * @return the all name by string builder
     * @throws SQLException the sql exception
     */
    public String getAllNameByStringBuilder() throws SQLException {
        return candidateDAO.getAllNameStringBuilder();
    }

    /**
     * in ra candidate count.
     *
     * @param experienceList the experience list
     * @param fresherList    the fresher list
     * @param internList     the intern list
     */
    public void getCount(List<Experience> experienceList, List<Fresher> fresherList, List<Intern>internList){
        System.out.println("Experience:");
        for(Experience ex: experienceList){
            System.out.println(ex.getFullName()+"  "+ex.candidateCount);
        }
        System.out.println("Fresher:");
        for(Fresher ex: fresherList){
            System.out.println(ex.getFullName()+"  "+ex.candidateCount);
        }
        System.out.println("Experience:");
        for(Intern ex: internList){
            System.out.println(ex.getFullName()+"  "+ex.candidateCount);
        }
    }
}
