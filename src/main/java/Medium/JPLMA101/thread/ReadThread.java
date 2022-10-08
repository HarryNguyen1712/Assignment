package Medium.JPLMA101.thread;


import Medium.JPLMA101.entities.CandidateMedium;

import Medium.JPLMA101.entities.ExperienceMedium;

import Medium.JPLMA101.entities.FresherMedium;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ReadThread extends Thread{
    private List<CandidateMedium> candidateList;
    private FresherMedium fresher;
    private ExperienceMedium experience;
    private String csvFile;
    private Thread t;
    private String threadName;

    private static final String FILE_HEADER ="first name,last name,birth date,address,phone,email,years experience,professional skill,graduation date,graduation rank,education";


    public ReadThread(String csvFile,String threadName,List<CandidateMedium>candidateList) {
        this.threadName = threadName;
        this.csvFile=csvFile;
        this.candidateList=candidateList;
    }

    public List<CandidateMedium> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<CandidateMedium> candidateList) {
        this.candidateList = candidateList;
    }

    synchronized void readCSV(String csvFile) throws IOException {

        try (Reader reader = new FileReader(csvFile);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(FILE_HEADER));){
            Iterable<CSVRecord> csvRecords= csvParser.getRecords();
            for (CSVRecord csv:csvRecords ) {
                if(csv.getRecordNumber()>1) {
                    FresherMedium fr= new FresherMedium();
                    ExperienceMedium ex= new ExperienceMedium();
                    if (Integer.parseInt(csv.get(6)) == 0) {
                        fr.parse(csv);
                        candidateList.add(fr);
                    } else {
                        ex.parse(csv);
                        candidateList.add(ex);
                    }
                }
            }
            /*candidateList= StreamSupport
                    .stream(csvRecords.spliterator(),false)
                    .map((CSVRecord csv)->{
                        Fresher fr;
                        Experience ex;
                        if(!csv.toString().equals(FILE_HEADER)){
                            System.out.println(csv.get(6));
                            if(Integer.parseInt(csv.get(6))==0){
                                fr=fresher.parse(csv);
                                return fr;
                            }
                            else{
                                ex=experience.parse(csv);
                                return ex;
                            }
                        }
                        return null;
                    }).collect(Collectors.toList());*/
        }
    }
        @Override
        public void run () {

            try {
                readCSV(csvFile);
                Thread.sleep(50);
            } catch (Exception e) {
                System.out.println("Error in CsvFileWriter!!!");
                System.out.println("Thread " + threadName + " interrupted.");
                e.printStackTrace();
            }
            System.out.println("Thread " + threadName + " exiting.");
        }

        public void start () {
            System.out.println("Starting " + threadName);
            if (t == null) {
                t = new Thread(this, threadName);
                t.start();
            }
        }
}
