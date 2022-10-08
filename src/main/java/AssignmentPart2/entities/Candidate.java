package AssignmentPart2.entities;



import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public  class Candidate{

     private int  candidateID;
     private String fullName;
     private LocalDate birthDay;
     private String phone;
     private String email;
     private int candidateType;
     private List<Certificate> certificateList;
     public int candidateCount;



    public List<Certificate> getCertificateList() {
        return certificateList;
    }

    public void setCertificateList(List<Certificate> certificateList) {
        this.certificateList = certificateList;
    }


    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
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

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }

    public Candidate() {
    }

    public Candidate(int candidateID, String fullName, LocalDate birthDay, String phone, String email, int candidateType, List<Certificate> certificateList) {
        this.candidateID = candidateID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
        this.certificateList = certificateList;
    }



    public void candidateCount(){
        candidateCount+=1;
    }
    public String showMe(){
        return "Candidate ID:"+ this.candidateID+"\nCandidate Name:"+ this.fullName+"\nBirthDay:"+ this.birthDay+"\nPhone:"+ this.phone+"\nEmail:"+ this.email+"\nCandidate Type:"+ this.candidateType;
    };



    @Override
    public boolean equals(Object o) {
        if(o instanceof Candidate candidate){
            return this.candidateID==candidate.getCandidateID();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.candidateID;
    }
}
