package Medium.JPLMA101.entities;

import org.apache.commons.csv.CSVRecord;

import java.time.LocalDate;

public class ExperienceMedium extends CandidateMedium{
    private int yearsExperience;
    private String professionalSkill;

    public ExperienceMedium() {
    }

    public ExperienceMedium(String firstname, String lastname, String address, String phone, String email, LocalDate birthdate, int yearsExperience, String professionalSkill) {
        super(firstname, lastname, address, phone, email, birthdate);
        this.yearsExperience = yearsExperience;
        this.professionalSkill = professionalSkill;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public String getProfessionalSkill() {
        return professionalSkill;
    }

    public void setProfessionalSkill(String professionalSkill) {
        this.professionalSkill = professionalSkill;
    }

    @Override
    public void parse(CSVRecord csvRecord) {
        ExperienceMedium ex= new ExperienceMedium();
        String firstName= csvRecord.get(0);
        this.setFirstname(firstName);
        String lastName= csvRecord.get(1);
        this.setLastname(lastName);
        LocalDate birthDate= LocalDate.parse(csvRecord.get(2));
        this.setBirthdate(birthDate);
        String address= csvRecord.get(3);
        this.setAddress(address);
        String phone= csvRecord.get(4);
        this.setPhone(phone);
        String email= csvRecord.get(5);
        this.setEmail(email);
        int yearExperience= Integer.parseInt(csvRecord.get(6));
        String professionalSkill=csvRecord.get(7);
        this.setYearsExperience(yearExperience);
        this.setProfessionalSkill(professionalSkill);


    }
}
