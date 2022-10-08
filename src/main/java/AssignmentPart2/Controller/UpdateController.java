package AssignmentPart2.Controller;

import AssignmentPart2.Configuration.DBconfig;
import AssignmentPart2.Dao.CandidateDAO;
import AssignmentPart2.entities.Candidate;
import AssignmentPart2.entities.Experience;
import AssignmentPart2.entities.Fresher;
import AssignmentPart2.entities.Intern;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateController {
    CandidateDAO candidateDAO= new CandidateDAO();
    public void updateCandidate(Candidate candidate) throws SQLException {
            candidateDAO.updateCandidate(candidate);

        }

}
