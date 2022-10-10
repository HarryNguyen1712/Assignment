package AssignmentPart2.Dao;

import AssignmentPart2.Configuration.DBconfig;
import AssignmentPart2.Utilis.Log4j;
import AssignmentPart2.entities.*;
import AssignmentPart2.exception.BirthDayException;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import validate.Validate;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static validate.Validate.validateBirthDay;

public class CandidateDAO {
    static Scanner sc = new Scanner(System.in);
    static DBconfig dBconfig = new DBconfig();
    /*public void getCount(List<Experience> experienceList, List<Fresher> fresherList, List<Intern>internList){
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
    }*/
    /*public Experience insertExperience(Experience ex){
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
    }*/


    /*public void insertCandidateForAll(Candidate d){
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
        LocalDate date= LocalDate.parse(sc.nextLine());
        boolean booleanBirthday=false;
        while(!booleanBirthday){
            try{
                validateBirthDay(date);
            }
            catch (BirthDayException e1) {
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
        d.setEmail(email);

    }*/
    public void updateCandidate(Candidate candidate) throws SQLException {
        Connection connection = dBconfig.getInstance();
        String sql= "SELECT * FROM candidate";
        Statement statement= connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs= statement.executeQuery(sql);
        try{
            while(rs.next()){
                // Lay du lieu boi su dung ten cot
                if(rs.getInt("candidateID")==candidate.getCandidateID()){
                    rs.updateString("fullName",candidate.getFullName());
                    rs.updateDate("birthDay",java.sql.Date.valueOf(candidate.getBirthDay()));
                    rs.updateString("phone", candidate.getPhone());
                    rs.updateString("email",candidate.getEmail());
                    rs.updateInt("candidateType",candidate.getCandidateType());
                    if(candidate.getCandidateType()==0){
                        Experience ex= (Experience) candidate;
                        rs.updateInt(6,0);
                        rs.updateInt(7,ex.getExpInYear());
                        rs.updateString(8,ex.getProSkill());
                        rs.updateString(9,null);
                        rs.updateString(10,null);
                        rs.updateString(11,null);
                        rs.updateString(12,null);
                        rs.updateString(13,null);
                        rs.updateString(14,null);

                    } else if (candidate.getCandidateType() ==1) {
                        Fresher fr= (Fresher) candidate;
                        rs.updateInt(6,1);
                        rs.updateInt(7,0);
                        rs.updateString(8,null);
                        rs.updateString(9,fr.getGraduationDate());
                        rs.updateString(10,fr.getGraduationRank());
                        rs.updateString(11,fr.getEducation());
                        rs.updateString(12,null);
                        rs.updateString(13,null);
                        rs.updateString(14,null);

                    }
                    else{
                        Intern it= (Intern) candidate;
                        rs.updateInt(6,2);
                        rs.updateInt(7,0);
                        rs.updateString(8,null);
                        rs.updateString(9,null);
                        rs.updateString(10,null);
                        rs.updateString(11,null);
                        rs.updateString(12,it.getMajors());
                        rs.updateString(13,it.getSemester());
                        rs.updateString(14,it.getUniversityName());
                    }
                    rs.updateRow();
                }
                Log4j.info(sql);
            }
        } catch (SQLException e) {
            Log4j.error(e.getMessage());
            throw new SQLException(e);

        }

    }
    public void addCandidate(Candidate candidate) throws SQLException {
        Connection connection = dBconfig.getInstance();
        String sql= "SELECT * FROM candidate";
        Statement statement= connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs= statement.executeQuery(sql);

        // Lay du lieu boi su dung ten cot
        rs.moveToInsertRow();
        rs.updateInt("candidateID",candidate.getCandidateID());
        rs.updateString("fullName",candidate.getFullName());
        rs.updateDate("birthDay",java.sql.Date.valueOf(candidate.getBirthDay()));
        rs.updateString("phone", candidate.getPhone());
        rs.updateString("email",candidate.getEmail());
        rs.updateInt("candidateType",candidate.getCandidateType());
        if(candidate.getCandidateType()==0){
            Experience ex= (Experience) candidate;
            rs.updateInt(6,0);
            rs.updateInt(7,ex.getExpInYear());
            rs.updateString(8,ex.getProSkill());
            rs.updateString(9,null);
            rs.updateString(10,null);
            rs.updateString(11,null);
            rs.updateString(12,null);
            rs.updateString(13,null);
            rs.updateString(14,null);

        } else if (candidate.getCandidateType() ==1) {
            Fresher fr= (Fresher) candidate;
            rs.updateInt(6,1);
            rs.updateInt(7,0);
            rs.updateString(8,null);
            rs.updateString(9,fr.getGraduationDate());
            rs.updateString(10,fr.getGraduationRank());
            rs.updateString(11,fr.getEducation());
            rs.updateString(12,null);
            rs.updateString(13,null);
            rs.updateString(14,null);

        }
        else{
            Intern it= (Intern) candidate;
            rs.updateInt(6,2);
            rs.updateInt(7,0);
            rs.updateString(8,null);
            rs.updateString(9,null);
            rs.updateString(10,null);
            rs.updateString(11,null);
            rs.updateString(12,it.getMajors());
            rs.updateString(13,it.getSemester());
            rs.updateString(14,it.getUniversityName());
        }
        rs.insertRow();
        Log4j.info(sql+" inserted");

    }
    public List<Candidate> getAllCandidate() throws SQLServerException {
        Connection connection = dBconfig.getInstance();
        List<Candidate> candidates= new ArrayList<>();
        String sql= "SELECT * FROM [dbo].[candidate]";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = null;
            rs= ps.executeQuery();
            while(rs.next()){
                int candidateID= rs.getInt("candidateID");
                String fullName= rs.getString("fullName");
                LocalDate birthDay= rs.getDate("birthDay").toLocalDate();
                String phone= rs.getString("phone");
                String email =rs.getString("email");
                int candidateType=rs.getInt("candidateType");
                Candidate candidate;
                if(candidateType==0){
                    int expInYear= rs.getInt("expInYear");
                    String proSkill= rs.getString("proSkill");
                    candidate= new Experience(candidateID,fullName,birthDay,phone,email,candidateType,null,expInYear,proSkill);
                } else if (candidateType==1) {
                    String graduationDate= rs.getString("graduationDate");
                    String graduationRank =rs.getString("graduationRank");
                    String education = rs.getString("education");
                    candidate= new Fresher(candidateID,fullName,birthDay,phone,email,candidateType,null,graduationDate,graduationRank,education);
                }
                else {
                    String majors= rs.getString("majors");
                    String semester =rs.getString("semester");
                    String universityName = rs.getString("universityName");
                    candidate= new Intern(candidateID,fullName,birthDay,phone,email,candidateType,null,majors,semester,universityName);
                }
                candidates.add(candidate);
            }
            Log4j.info(sql+ "get all candidates");
            candidates.sort(Comparator.comparing(Candidate::getCandidateType).thenComparing(Candidate::getBirthDay));
        } catch (SQLException ex) {
            Log4j.error(ex.getMessage());

            ex.printStackTrace();
        }
        return candidates;
    }


    /*public Intern insertIntern(Intern intern) throws SQLServerException {
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
    }*/
    public void insert(Candidate d) throws SQLException {
        Connection conn = dBconfig.getInstance();

        String sql="INSERT INTO [dbo].[candidate] values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int i=d.getCandidateType() ;
        addCandidate(d);

//        prepareSta(d, conn, sql, i);

        //insertCertificate(d.getCertificateList(),d.getCandidateID());
    }
    public void insertCertificate(List<Certificate> d, int i) throws SQLServerException {
        Connection conn = dBconfig.getInstance();
        String sqlCertificate="";

    }
    private void prepareSta(Candidate d, Connection conn, String sql, int i) {
        PreparedStatement ps ;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, d.getCandidateID());
            ps.setString(2, d.getFullName());
            ps.setDate(3, java.sql.Date.valueOf(d.getBirthDay()));
            ps.setString(4, d.getPhone());
            ps.setString(5, d.getEmail());
            if(i ==0){
                Experience ex= (Experience) d;
                ps.setInt(6,0);
                ps.setInt(7,ex.getExpInYear());
                ps.setString(8,ex.getProSkill());
                ps.setString(9,null);
                ps.setString(10,null);
                ps.setString(11,null);
                ps.setString(12,null);
                ps.setString(13,null);
                ps.setString(14,null);

            } else if (i ==1) {
                Fresher fr= (Fresher) d;
                ps.setInt(6,1);
                ps.setInt(7,0);
                ps.setString(8,null);
                ps.setString(9,fr.getGraduationDate());
                ps.setString(10,fr.getGraduationRank());
                ps.setString(11,fr.getEducation());
                ps.setString(12,null);
                ps.setString(13,null);
                ps.setString(14,null);

            }
            else{
                Intern it= (Intern) d;
                ps.setInt(6,2);
                ps.setInt(7,0);
                ps.setString(8,null);
                ps.setString(9,null);
                ps.setString(10,null);
                ps.setString(11,null);
                ps.setString(12,it.getMajors());
                ps.setString(13,it.getSemester());
                ps.setString(14,it.getUniversityName());
            }
            ps.executeUpdate();
            Log4j.info(sql+" insert");
        } catch (SQLException e) {
            e.printStackTrace();
            Log4j.error(e.getMessage());
        }

    }
    public String getAllName() throws SQLException {
        try{
            List<Candidate> candidates = getAllCandidate();
            String names= "";
            for(Candidate cd:candidates){
                names=names + cd.getFullName()+",";
            }
            return names;
        } catch (SQLException e) {
            Log4j.error(e.getMessage());
            throw new SQLException();

        }


    }
    public String getAllNameStringBuilder() throws SQLException {

        try{
            List<Candidate> candidates = getAllCandidate();
            StringBuffer names= new StringBuffer();
            for(Candidate cd:candidates){
                names.append(cd.getFullName()).append(",");
            }
            return names.toString();
        } catch (SQLException e) {
            Log4j.error(e.getMessage());
            throw new SQLException();
        }
    }
}
