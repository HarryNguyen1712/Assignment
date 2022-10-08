package AssignmentPart2.Controller;

import AssignmentPart2.Configuration.DBconfig;
import AssignmentPart2.Dao.CandidateDAO;
import AssignmentPart2.entities.Candidate;
import AssignmentPart2.entities.Experience;
import AssignmentPart2.entities.Fresher;
import AssignmentPart2.entities.Intern;
import AssignmentPart2.exception.BirthDayException;
import AssignmentPart2.exception.EmailException;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import validate.Validate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import static validate.Validate.validateBirthDay;
import static validate.Validate.validateEmail2;

public class InsertController {
    static Scanner sc = new Scanner(System.in);
    static DBconfig dBconfig = new DBconfig();
    CandidateDAO candidateDAO= new CandidateDAO();

    /**
     * Insert experience candidate.
     *
     * @param ex experience
     * @return the experience
     */
    public Experience insertExperience(Experience ex){
        ex.setCandidateType(0);
        insertCandidateForAll(ex);
        int output;

        System.out.println("nhap so nam kinh nghiem");
        String expInYear= sc.nextLine();
        while(!Validate.validateIntWithoutRound(expInYear) || !Validate.validatePositive(Double.parseDouble(expInYear))){
            System.out.println("So nam kinh nghiem phai la so nguyen duong");
            expInYear=sc.nextLine();
        }
        output=Integer.parseInt(expInYear);
        ex.setExpInYear(output);

        System.out.println("nhap ky nang chuyen mon");
        String proSkill =sc.nextLine();
        ex.setProSkill(proSkill);

        return ex;
    }


    /**
     * Insert fresher fresher.
     *
     * @param fr the fr
     * @return the fresher
     */
    public Fresher insertFresher(Fresher fr){
        fr.setCandidateType(1);
        insertCandidateForAll(fr);

        System.out.println("nhap thoi gian tot nghiep");
        String graduationDate= sc.nextLine();
        fr.setGraduationDate(graduationDate);

        System.out.println("nhap xep loai tot nghiep");
        String graduationRank =sc.nextLine();
        fr.setGraduationRank(graduationRank);

        System.out.println("nhap truong tot nghiep");
        String education =sc.nextLine();
        fr.setEducation(education);
        return fr;
    }

    /**
     * Insert intern intern.
     *
     * @param intern the intern
     * @return the intern
     */
    public Intern insertIntern(Intern intern) {
        intern.setCandidateType(2);
        insertCandidateForAll(intern);


        System.out.println("nhap chuyen nganh");
        String major =sc.nextLine();
        intern.setMajors(major);

        System.out.println("nhap hoc ki");
        String semester = sc.nextLine();
        intern.setSemester(semester);

        System.out.println("nhap truong dang hoc");
        String university = sc.nextLine();
        intern.setUniversityName(university);
        return intern;
    }

    /**
     * Insert candidate for 3 type candidate.
     *
     * @param d candidate
     */
    public void insertCandidateForAll(Candidate d){
        System.out.println("Nhap Candidate ID");
        String candidateID= sc.nextLine();
        int output;
        while(!Validate.validateInt(candidateID) || !Validate.validatePositive(Double.parseDouble(candidateID))){
            System.out.println("Candidate ID phai la so nguyen duong");
            candidateID=sc.nextLine();
        }

        output=(int)Math.round(Double.parseDouble(candidateID));
        d.setCandidateID(output);



        System.out.println("Nhap Full Name");
        String fullName=sc.nextLine();
        d.setFullName(fullName);

        System.out.println("nhap ngay thang nam sinh");
        LocalDate date= null;
        boolean booleanBirthday=false;
        while(!booleanBirthday){
            try{
                date= LocalDate.parse(sc.nextLine());
                validateBirthDay(date);
            }
            catch (BirthDayException | DateTimeParseException e1) {
                System.out.println(e1.getMessage());
                System.out.println("Please input again");
                date= LocalDate.parse(sc.nextLine());
                continue;
            }
            booleanBirthday=true;
        }


        d.setBirthDay(date);


        System.out.println("nhap so dien thoai");
        String phone =sc.nextLine();
        d.setPhone(phone);


        System.out.println("nhap email");
        String email =sc.nextLine();

        boolean booleanEmail=false;
        while(!booleanEmail){
            try{
                validateEmail2(email);
            }
            catch (EmailException e1) {
                System.out.println(e1.getMessage());
                System.out.println("Please input again");
                email= sc.nextLine();
                continue;
            }
            booleanEmail=true;
        }
        d.setEmail(email);

    }

    /**
     * Add candidate.
     *
     * @param candidate candidate
     * @throws SQLException the sql exception
     */
    public void addCandidate(Candidate candidate) throws SQLException {
        candidateDAO.addCandidate(candidate);
    }

    /**
     * Insert.
     *
     * @param d candidate
     * @throws SQLException the sql exception
     */
    public void insert(Candidate d) throws SQLException {
        candidateDAO.insert(d);
//        prepareSta(d, conn, sql, i);

        //insertCertificate(d.getCertificateList(),d.getCandidateID());
    }
}
