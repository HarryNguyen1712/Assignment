package AssignmentPart2.entities;

import java.time.LocalDate;
import java.util.List;

public class Intern extends Candidate {

    private String majors;
    private String semester;
    private String universityName;

    public Intern() {
    }

    public Intern(int candidateID, String fullName, LocalDate birthDay, String phone, String email, int candidateType, List<Certificate> certificateList, String majors, String semester, String universityName) {
        super(candidateID, fullName, birthDay, phone, email, candidateType, certificateList);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String showMe() {
        return super.showMe()+"\nMajor:"+ this.majors+"\nSemester:"+ this.semester+"\nUniversity Name:"+ this.universityName;
    }
}
