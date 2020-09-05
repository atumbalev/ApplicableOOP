import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Friday13Calculator {
    public static int countAllFriday13(int year) {
        DateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
        Date date = null;
        try {
            date = dateFormat.parse("13/01/" + year);
        } catch (ParseException e) {
            System.err.println("Invalid date");
            System.exit(1);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int count = 0;
        int month = 0;

        while (month++ <= 12) {
            if (Calendar.FRIDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
                ++count;
            }
            calendar.add(Calendar.MONTH, 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int year = random.nextInt(1000) + 1000;
        System.out.printf("The year %d has %d Friday the 13ths", year, countAllFriday13(year));
    }
}
