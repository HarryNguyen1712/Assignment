package Medium.JPLMA101;


import Medium.JPLMA101.entities.CandidateMedium;

import Medium.JPLMA101.entities.ExperienceMedium;
import Medium.JPLMA101.entities.FresherMedium;
import Medium.JPLMA101.thread.DisplayThread;
import Medium.JPLMA101.thread.ReadThread;
import Medium.JPLMA101.thread.WriteThread;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CandidateManagement {
    public static void main(String[] args) {
        List<CandidateMedium> candidateList= new ArrayList<>();
        ExperienceMedium ex1= new ExperienceMedium("nguyen","huy","Da Nang","0935016256","anhhuy@gmail.com",LocalDate.parse("1999-12-17"),2,"java");
        ExperienceMedium ex2= new ExperienceMedium("nguyen","huy","Da Nang","0935016256","anhhuy@gmail.com",LocalDate.parse("1999-12-17"),2,"java");
        FresherMedium fr1= new FresherMedium("nguyen","huy","Da Nang","0935016256","anhhuy@gmail.com",LocalDate.parse("2000-12-10"),"2023","gioi","dut");
        FresherMedium fr2= new FresherMedium("nguyen","huy","Da Nang","0935016256","anhhuy@gmail.com",LocalDate.parse("2000-12-10"),"2023","gioi","dut");
        candidateList.add(ex1);
        candidateList.add(ex2);
        candidateList.add(fr1);
        candidateList.add(fr2);
        WriteThread thread1=new WriteThread("Write Thread",candidateList);
        ReadThread thread2= new ReadThread("D:\\FSOFT JAVA FRESHER\\JPL\\Assignment\\JPLMA101 - 2.csv","ReadThread",new ArrayList<>());
        DisplayThread thread3= new DisplayThread("DisplayThread",candidateList);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
