package Medium.JPLMA101.thread;


import Medium.JPLMA101.entities.CandidateMedium;

import Medium.JPLMA101.entities.ExperienceMedium;

import Medium.JPLMA101.entities.FresherMedium;
import dnl.utils.text.table.TextTable;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DisplayThread  extends Thread{
    private Thread t;
    private String threadName;
    private List<CandidateMedium> candidateList;
    private static final String COMMA_DELIMITER=",";
    private static final String NEW_LINE_SEPARATOR="\n";
    private static final String FILE_HEADER ="first name,last name,birth date,address,phone,email,years experience,professional skill,graduation date,graduation rank,education";
    String[] columnNames={
            "first name",
            "last name",
            "birth date",
            "address",
            "phone",
            "email",
            "years experience",
            "professional skill",
            "graduation date",
            "graduation rank",
            "education"};
    Object[][] data;
    public DisplayThread(String threadName, List<CandidateMedium> candidateList) {
        this.threadName = threadName;
        this.candidateList = candidateList;
    }

    public List<CandidateMedium> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<CandidateMedium> candidateList) {
        this.candidateList = candidateList;
    }

    synchronized void  displayInTable(FileWriter fileWriter) throws IOException {
        fileWriter.append(FILE_HEADER).append(NEW_LINE_SEPARATOR);
        for(CandidateMedium d:candidateList){
            fileWriter.append(d.getFirstname());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(d.getLastname());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(d.getBirthdate().toString());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(d.getAddress());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(d.getPhone());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(d.getEmail());
            fileWriter.append(COMMA_DELIMITER);
            if(d instanceof ExperienceMedium ex){
                fileWriter.append(Integer.toString(ex.getYearsExperience()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(ex.getProfessionalSkill());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("null");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("null");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("null");
            }
            if(d instanceof FresherMedium fresher){
                fileWriter.append("0");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("null");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(fresher.getGraduationDate());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(fresher.getGraduationRank());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(fresher.getEducation());
            }
            fileWriter.append(NEW_LINE_SEPARATOR);
        }
    }
    @Override
    public void run() {
        FileWriter fileWriter=null;
        String fileName="JPLMA101.csv";
        data= new Object[candidateList.size()][11];
        int i=0;
        try {
            for(CandidateMedium candidate:candidateList){
                data[i][0]=candidate.getFirstname();
                data[i][1]=candidate.getLastname();
                data[i][2]=candidate.getBirthdate();
                data[i][3]=candidate.getAddress();
                data[i][4]=candidate.getPhone();
                data[i][5]=candidate.getEmail();
                if(candidate instanceof ExperienceMedium e){

                    data[i][6]=e.getYearsExperience();
                    data[i][7]=e.getProfessionalSkill();
                    data[i][8]=null;
                    data[i][9]=null;
                    data[i][10]=null;
                } else if (candidate instanceof FresherMedium fr) {
                    data[i][6]=null;
                    data[i][7]=null;
                    data[i][8]=fr.getGraduationDate();
                    data[i][9]=fr.getGraduationDate();
                    data[i][10]=fr.getEducation();
                }

                i++;
            }
            Thread.sleep(50);
        }
        catch (Exception e) {

            e.printStackTrace();
        }
        finally {
            TextTable tt = new TextTable(columnNames, data);
// this adds the numbering on the left
            tt.setAddRowNumbering(true);
// sort by the first column
            tt.setSort(0);
            tt.printTable();

        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
