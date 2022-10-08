package AssignmentPart1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class bai10 {

    private static final String COMMA_DELIMITER=",";
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Za-z0-9+_.-]+@fsoft.com.vn");
    private static final Pattern PHONE_REGEX = Pattern.compile("^\\d{9}$");
    private static List<String> parseCsvLine(String csvLine) {
        List<String> result= new ArrayList<String>();
        if(csvLine!=null){
            String[] splitData=csvLine.split(COMMA_DELIMITER);
            result.addAll(Arrays.asList(splitData));
        }
        return result;
    }

    public static void printStd(List<String> student){
        System.out.println("Student Number:"+student.get(0)
                +", Student Name:"+student.get(1)
                +", Phone Number:"+student.get(2)
                +", Email:"+student.get(3)
                +", Grade:"+student.get(4));
    }
    public static StringBuilder checkStdInfo(List<String> student,int line){
        StringBuilder sb= new StringBuilder();
        sb.append("Line ").append(line).append(": co loi dinh dang ");
        if(!PHONE_REGEX.matcher(student.get(2)).matches()){
            sb.append("StdPhone");
        }
        if(!EMAIL_REGEX.matcher(student.get(3)).matches()){
            if(sb.toString().contains("StdPhone")){
                sb.append(", ");
            }
            sb.append("StdEmail");
        }
        if(sb.toString().contains("StdPhone") || sb.toString().contains("StdEmail")){
            return sb.append("\n");
        }
        else
            return null;
    }


    public static void readCSVAndWriteError(){
        BufferedReader br=null;
        FileWriter fileWriter=null;
        try{
            String line;
            br = new BufferedReader(new FileReader("D:\\FSOFT JAVA FRESHER\\JPL\\test.csv"));
            String error= "error.txt";
            fileWriter = new FileWriter(error);
            StringBuilder sb;
            int NoLine=1;
            while((line=br.readLine())!=null){
                sb= new StringBuilder();
                sb.append(checkStdInfo(parseCsvLine(line),NoLine));
                if(!sb.toString().contains("null")){
                    System.out.println(sb.toString());
                    fileWriter.append(sb.toString());
                }
                else{

                    printStd(parseCsvLine(line));
                }
                NoLine++;

            }
            System.out.println("Error file was  created");
        } catch (IOException e) {
            System.out.println("created failed");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                if(br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        readCSVAndWriteError();
    }

}
