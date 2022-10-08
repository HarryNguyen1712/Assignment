package Medium.JPLMA101.entities;

import AssignmentPart2.entities.Candidate;
import org.apache.commons.csv.CSVRecord;

import java.time.LocalDate;

public abstract class CandidateMedium {
    private String firstname, lastname, address, phone, email;
    private LocalDate birthdate;

    public CandidateMedium() {
    }

    public CandidateMedium(String firstname, String lastname, String address, String phone, String email, LocalDate birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.email = email;

        this.birthdate = birthdate;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

      /*public void parse(CSVRecord csvRecord, CandidateMedium candidateMedium){
        String firstName= csvRecord.get(0);
        candidateMedium.setFirstname(firstName);
        String lastName= csvRecord.get(1);
        candidateMedium.setLastname(lastName);
        LocalDate birthDate= LocalDate.parse(csvRecord.get(2));
        candidateMedium.setBirthdate(birthDate);
        String address= csvRecord.get(3);
        candidateMedium.setAddress(address);
        String phone= csvRecord.get(4);
        candidateMedium.setPhone(phone);
        String email= csvRecord.get(5);
        candidateMedium.setEmail(email);
        System.out.println(firstName);
    }*/

    public abstract void parse(CSVRecord csvRecord);
}
