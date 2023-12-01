import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a date in the format dd/MM/yyyy: ");
        String inputDate = scanner.nextLine();

        if (isValidDate(inputDate, "dd/MM/yyyy")) {
            System.out.println(inputDate + " is a valid date.");
        } else {
            System.out.println(inputDate + " is not a valid date.");
        }
    }

    public static boolean isValidDate(String dateStr, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false); // Disable lenient parsing

        try {
            Date date = sdf.parse(dateStr);
            // Check if the parsed date matches the original input
            return dateStr.equals(sdf.format(date));
        } catch (ParseException e) {
            // ParseException indicates an invalid date
            return false;
        }
    }
}
