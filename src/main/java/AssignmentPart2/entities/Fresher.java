package AssignmentPart2.entities;

import java.time.LocalDate;
import java.util.List;

public class Fresher extends Candidate {
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
    }

    public Fresher(int candidateID, String fullName, LocalDate birthDay, String phone, String email, int candidateType, List<Certificate> certificateList, String graduationDate, String graduationRank, String education) {
        super(candidateID, fullName, birthDay, phone, email, candidateType, certificateList);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String showMe() {
        return super.showMe()+"\nGraduation Date:"+ this.graduationDate+"\nGraduation Rank:"+ this.graduationRank;
    }
}
