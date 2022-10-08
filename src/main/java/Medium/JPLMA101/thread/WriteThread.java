package Medium.JPLMA101.thread;


import Medium.JPLMA101.entities.CandidateMedium;

import Medium.JPLMA101.entities.ExperienceMedium;

import Medium.JPLMA101.entities.FresherMedium;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteThread extends Thread {
    private Thread t;
    private String threadName;
    private List<CandidateMedium> candidateList;
    private static final String COMMA_DELIMITER=",";
    private static final String NEW_LINE_SEPARATOR="\n";
    private static final String FILE_HEADER ="first name,last name,birth date,address,phone,email,years experience,professional skill,graduation date,graduation rank,education";

    public WriteThread(String threadName, List<CandidateMedium> candidateList) {
        this.threadName = threadName;
        this.candidateList = candidateList;
    }

    synchronized void  writeCSV(FileWriter fileWriter) throws IOException {
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
        try {
                fileWriter= new FileWriter(fileName);
                writeCSV(fileWriter);
                Thread.sleep(50);
            }
        catch (Exception e) {
            System.out.println("Error in CsvFileWriter!!!");
            System.out.println("Thread " + threadName + " interrupted.");
            e.printStackTrace();
        }
        finally {
            try {
                assert fileWriter != null;
                fileWriter.flush();
                fileWriter.close();
            }catch (IOException exception){
                System.out.println("Error whilte flushing/closing file");
                exception.printStackTrace();
            }
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
