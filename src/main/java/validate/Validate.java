package validate;

import AssignmentPart2.exception.BirthDayException;
import AssignmentPart2.exception.EmailException;
import Long.JPLLA201.entities.Airport;
import Long.JPLLA201.entities.FixedWings;
import Long.JPLLA201.entities.Helicopters;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {

    private static final Pattern ISBN_REGEX= Pattern.compile("^([0-9](?:-[0-9]|[0-9]){6,10})$");
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Za-z0-9+_.-]+@fsoft.com.vn");
    private static final Pattern EMAIL_REGEX2 = Pattern.compile("^(.+)@(.+)$");
    public static boolean validateISBN(String isbn){
        return ISBN_REGEX.matcher(isbn).matches();
    }
    public static <T> boolean validateID(List<T> objectList, String ID){
        for(Object o:objectList){
            if(o instanceof Airport airport){
                if(airport.getID().equalsIgnoreCase(ID)){

                    return false;
                }
            }
            else if(o instanceof Helicopters helicopters){
                if(helicopters.getId().equalsIgnoreCase(ID)){
                    return false;
                }
            }
            else if(o instanceof FixedWings fixedWings){
                if(fixedWings.getId().equalsIgnoreCase(ID)){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean validateLengthString(String s){
        return s.length()==7;
    }
    public static boolean validateRunwaySize(FixedWings fixedWings,Airport airport){
        return fixedWings.getMinNeededRunwaySize()<airport.getRunwaySize();
    }
    public static boolean validateMaxTakeoffWeight (Helicopters helicopters){
        return helicopters.getMaxTakeoffWeight()<=(1.5*helicopters.getEmptyWeight());
    }
    public static boolean validatePrefix(Object o, String ID){
        if(o instanceof Airport airport){
            return ID.startsWith("AP");

        }
        else if (o instanceof Helicopters helicopters){
            return ID.startsWith("RW");
        }
        else {
            return ID.startsWith("FW");
        }

    }
    public static boolean validateDouble(String strNum){
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static boolean validateInt(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = (int) Math.round(Double.parseDouble(strNum));
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static boolean validateIntWithoutRound(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static boolean validatePositive(double i){
        return !(i < 0);

//        do {
//            while (!sc.hasNextInt()) {
//                System.out.println("That's not a number!");
//                sc.next(); // this is important!
//            }
//            System.out.println("Please input again!");
//            i = sc.nextInt();
//        } while (i <= 0);
//        return i;
    }
    public static void validateBirthDay(LocalDate birthdayDate) throws BirthDayException{
        if(!(birthdayDate.getYear() > 1900 && birthdayDate.getYear() <= LocalDate.now().getYear())){
            throw new BirthDayException();
        }

    }
    public static boolean validateEmail(String email){
        return EMAIL_REGEX.matcher(email).matches();
    }
    public static void validateEmail2(String email2) throws EmailException {
        if(!EMAIL_REGEX2.matcher(email2).matches()){
            throw new EmailException();
        }
    }
}
