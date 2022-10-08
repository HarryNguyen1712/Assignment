package AssignmentPart2.entities;

import java.time.LocalDate;
import java.util.List;

public class Experience extends Candidate {
    private int expInYear;
    private String proSkill;

    public Experience() {

    }

    public Experience(int candidateID, String fullName, LocalDate birthDay, String phone, String email, int candidateType, List<Certificate> certificateList, int expInYear, String proSkill) {
        super(candidateID, fullName, birthDay, phone, email, candidateType, certificateList);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String showMe() {
        return super.showMe()+ "\nExpInYear: " + this.getExpInYear()+"\nPro Skill: "+ this.getProSkill();
    }
}
