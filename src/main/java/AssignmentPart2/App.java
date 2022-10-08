package AssignmentPart2;

import AssignmentPart2.Configuration.DBconfig;

import AssignmentPart2.Controller.GetController;
import AssignmentPart2.Controller.InsertController;
import AssignmentPart2.Controller.UpdateController;
import AssignmentPart2.Dao.CandidateDAO;
import AssignmentPart2.entities.*;

import AssignmentPart2.helper.ConnectionPool;
import validate.Validate;

import javax.naming.CompositeName;
import javax.naming.InvalidNameException;
import javax.naming.Name;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static DBconfig dBconfig = new DBconfig();
    static InsertController insert= new InsertController();
    static GetController get= new GetController();
    static UpdateController update= new UpdateController();

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InvalidNameException {
        /*Name objectName = new CompositeName("java:comp/env/jdbc");
        Enumeration<String> elements = objectName.getAll();
        while(elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection=connectionPool.getConnection();*/

        /*List<Candidate> candidateSet= new ArrayList<>();
        Candidate cd1=new Candidate(1,null,LocalDate.parse("1999-12-17"),null,null,1,null);
        Candidate aaaaa=new Fresher(1,null,LocalDate.parse("1999-12-17"),null,null,1,null,"2023","gioi",null);
        Candidate cd2=new Candidate(2,null,LocalDate.parse("2000-12-17"),null,null,1,null);
        Candidate cd3=new Candidate(3,null,LocalDate.parse("1988-12-17"),null,null,0,null);
        Candidate cd4=new Candidate(4,null,LocalDate.parse("2001-12-17"),null,null,0,null);
        Candidate cd5=new Candidate(5,null,LocalDate.parse("2000-12-17"),null,null,2,null);
        Candidate cd6=new Candidate(6,null,LocalDate.parse("2002-12-17"),null,null,2,null);
        candidateSet.add(cd1);
        candidateSet.add(cd2);
        candidateSet.add(cd3);
        candidateSet.add(cd4);
        candidateSet.add(cd5);
        candidateSet.add(cd6);

        for(Candidate cd: candidateSet){

            System.out.println(cd.getCandidateType()+"  "+cd.getBirthDay().getYear());
        }
        System.out.println("----------------------------");
        candidateSet.sort(Comparator.comparing(Candidate::getCandidateType).thenComparing(Candidate::getBirthDay));
        for(Candidate cd: candidateSet){

            System.out.println(cd.getCandidateType()+"  "+cd.getBirthDay().getYear());
        }
        System.out.println(((Fresher) aaaaa).getGraduationRank());*/


        System.out.println(get.getAllName());;
        System.out.println(get.getAllNameByStringBuilder());
        Set<Candidate> candidates = new HashSet<>(get.getAllCandidate());
        for(Candidate candidate:candidates){
            System.out.println(candidate.getCandidateID());
        }
        List<Experience> experiences =new ArrayList<>();
        List<Fresher> fresherList= new ArrayList<>();
        List<Intern> internList= new ArrayList<>();
        int countEx=0;
        int countFr=0;
        int countIn=0;
        boolean start = true;
        boolean temp=true;
        while (start) {
            System.out.println("Choose what function you want to process:");
            System.out.println("1.Experience ");
            System.out.println("2.Fresher");
            System.out.println("3.Intern");
            System.out.println("4.Sort list candidate");
            System.out.println("5.Update candidate");
            System.out.println("5.Exit ");
            System.out.println("_________________________");
            sc=new Scanner(System.in);
            int choice = Integer.parseInt(sc.nextLine());
            boolean inner = true;
            while (inner) {
                if(temp){
                    experiences =new ArrayList<>();
                    fresherList= new ArrayList<>();
                    internList= new ArrayList<>();
                    countEx=0;
                    countFr=0;
                    countIn=0;
                }
                switch (choice) {
                    case 1 -> {
                        inner = false;
                        Experience ex = new Experience();
                        System.out.println("_________________________");
                        insert.insert(insert.insertExperience(ex));
                        countEx += 1;
                        ex.candidateCount = countEx;
                        experiences.add(ex);
                        System.out.println("ban co muon nhap tiep khong(Y/N)");
                        String input = sc.nextLine();
                        if (input.equalsIgnoreCase("N")) {
                            get.getCount(experiences, fresherList, internList);
                            temp = true;
                        } else {
                            temp = false;
                        }
                        System.out.println("\n");
                        System.out.println("_________________________");
                    }
                    case 2 -> {
                        inner = false;
                        Fresher fr = new Fresher();
                        System.out.println("_________________________");
                        insert.insert(insert.insertFresher(fr));
                        countFr += 1;
                        fr.candidateCount = countFr;
                        fresherList.add(fr);
                        System.out.println("ban co muon nhap tiep khong(Y/N)");
                        String input2 = sc.nextLine();
                        if (input2.equalsIgnoreCase("N")) {
                            get.getCount(experiences, fresherList, internList);
                            temp = true;
                        } else {
                            temp = false;
                        }
                        System.out.println("_________________________");
                    }
                    case 3 -> {
                        inner = false;
                        Intern intern = new Intern();
                        System.out.println("_________________________");
                        insert.insert(insert.insertIntern(intern));
                        countIn += 1;
                        intern.candidateCount = countIn;
                        internList.add(intern);
                        System.out.println("ban co muon nhap tiep khong(Y/N)");
                        String input3 = sc.nextLine();
                        if (input3.equalsIgnoreCase("N")) {
                            get.getCount(experiences, fresherList, internList);
                            temp = true;
                        } else {
                            temp = false;
                        }
                        System.out.println("\n");
                        System.out.println("_________________________");
                    }
                    case 4 -> {
                        inner = false;
                        for(Candidate cd:get.getAllCandidate()){
                            System.out.println("-----------------------");
                            if(cd instanceof Experience){
                                System.out.println(((Experience)cd).showMe());
                            } else if (cd instanceof Fresher) {
                                System.out.println(((Fresher)cd).showMe());
                            } else {
                                System.out.println(((Intern)cd).showMe());
                            }
                        }
                        System.out.println("-----------------------");
                    }
                    case 5 -> {
                        inner = false;
                        System.out.println("Moi ban nhap CandidateID");
                        String candidateID= sc.nextLine();
                        while(!Validate.validateIntWithoutRound(candidateID) || !Validate.validatePositive(Double.parseDouble(candidateID))){
                            System.out.println("Candidate ID phai la so nguyen duong");
                            candidateID=sc.nextLine();
                        }
                        int candidateID1=Integer.parseInt(candidateID);
                        boolean temp1=false;
                        int choice1=0;
                        while(!temp1){
                            Candidate cd = null;
                            System.out.println("Choose what function you want to process:");
                            System.out.println("1.Experience ");
                            System.out.println("2.Fresher");
                            System.out.println("3.Intern");
                            choice1= Integer.parseInt(sc.nextLine());
                            switch (choice1){
                                case 1->{
                                    cd = new Experience();
                                    cd.setCandidateID(candidateID1);
                                    update.updateCandidate(insert.insertExperience((Experience) cd));
                                    temp1=true;
                                }
                                case 2->{
                                    cd = new Fresher();
                                    cd.setCandidateID(candidateID1);
                                    update.updateCandidate(insert.insertFresher((Fresher) cd));
                                    temp1=true;
                                }
                                case 3->{
                                    cd = new Intern();
                                    cd.setCandidateID(candidateID1);
                                    update.updateCandidate(insert.insertIntern((Intern) cd));
                                    temp1=true;
                                }
                                default -> {
                                    System.out.println("moi ban nhap lai");
                                }
                            }
                        }
                    }
                    case 6 -> {
                        inner = false;
                        start = false;
                    }
                    default -> {
                        System.out.println("_________________________");
                        System.out.println("Wrong choice");
                        System.out.println("Try again please");
                        choice = Integer.parseInt(sc.nextLine());
                        System.out.println("_________________________");
                    }
                }
            }
        }



    }
    /*public static void getCount(List<Experience> experienceList,List<Fresher> fresherList,List<Intern>internList){
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
    }
    public static Experience insertExperience(Experience ex){
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




    public static Fresher insertFresher(Fresher fr){
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


    public static void insertCandidateForAll(Candidate d){
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

    }
    public static void updateCandidate(Candidate candidate) throws SQLException {
        Connection connection = dBconfig.getInstance();
        String sql= "SELECT * FROM candidate";
        Statement statement= connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs= statement.executeQuery(sql);
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

        }
    }
    public static void addCandidate(Candidate candidate) throws SQLException {
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


    }
    public static List<Candidate> getAllCandidate() throws SQLServerException {
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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return candidates;
    }


    public static Intern insertIntern(Intern intern) throws SQLServerException {
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
    public static void insert(Candidate d) throws SQLException {
        Connection conn = dBconfig.getInstance();

        String sql="INSERT INTO [dbo].[candidate] values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int i=d.getCandidateType() ;
        addCandidate(d);
//        prepareSta(d, conn, sql, i);

        //insertCertificate(d.getCertificateList(),d.getCandidateID());
    }
    public static void insertCertificate(List<Certificate> d,int i) throws SQLServerException {
        Connection conn = dBconfig.getInstance();
        String sqlCertificate="";

    }
    private static void prepareSta(Candidate d, Connection conn, String sql, int i) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/





}
