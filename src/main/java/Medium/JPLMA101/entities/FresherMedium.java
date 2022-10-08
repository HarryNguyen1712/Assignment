package Medium.JPLMA101.entities;

import org.apache.commons.csv.CSVRecord;

import java.time.LocalDate;

public class FresherMedium extends CandidateMedium{
    private String graduationDate, graduationRank, education;

    public FresherMedium() {
    }

    public FresherMedium(String firstname, String lastname, String address, String phone, String email, LocalDate birthdate, String graduationDate, String graduationRank, String education) {
        super(firstname, lastname, address, phone, email, birthdate);
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
    public void parse(CSVRecord csvRecord) {

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

            String graduationDate=csvRecord.get(8);
            String graduationRank= csvRecord.get(9);
            String education= csvRecord.get(10);
        this.setGraduationDate(graduationDate);
        this.setGraduationRank(graduationRank);
        this.setEducation(education);



    }
}
