package Long.JPLLA202.utilis;

import AssignmentPart2.exception.EmailException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class Validate {
    private static final Pattern PHONE_REGEX = Pattern.compile("^\\d{7}$");
    private static final Pattern EMAIL_REGEX2 = Pattern.compile("^(.+)@(.+)$");
    public static boolean validatePhone(String phone){
        return PHONE_REGEX.matcher(phone).matches();
    }
    public static boolean validateDate(String date)  {
        try{
            LocalDate date1=LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return true;
        }
        catch (DateTimeParseException p){
            return false;
        }
    }
    public static void validateEmail2(String email2) throws EmailException {
        if(!EMAIL_REGEX2.matcher(email2).matches()){
            throw new EmailException();
        }
    }
}
