package helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class Common {

    public static String uniqueValue = generateRandom();

    public static String getConfigValue(String key) {
        ResourceBundle config = ResourceBundle.getBundle("config");
        return config.getString(key);
    }

    public static String getUniqueValue(String value) {
        return value + uniqueValue;
    }

    public static String getUniqueEmail(String email) {
        String[] parsedEmail = email.split("@");
        return getUniqueValue(parsedEmail[0]) + "@" + parsedEmail[1];
    }

    public static String generateRandom() {
        return "-" + getCurrentTimeStampString();
    }

    private static String getCurrentTimeStampString() {
        java.util.Date date = new java.util.Date();

        SimpleDateFormat sd = new SimpleDateFormat();
        TimeZone timeZone = TimeZone.getDefault();
        Calendar calendar = Calendar.getInstance(new SimpleTimeZone(timeZone.getOffset(date.getTime()), "GMT"));
        sd.setCalendar(calendar);

        return sd.format(date);
    }

    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getNumberOfTheDayOfWeek(String dayOfWeek) {
        String numberOfDay;
        if (dayOfWeek.equalsIgnoreCase("sun")) {
            numberOfDay = "0";
        } else if (dayOfWeek.equalsIgnoreCase("mon")) {
            numberOfDay = "1";
        } else if (dayOfWeek.equalsIgnoreCase("tue")) {
            numberOfDay = "2";
        } else if (dayOfWeek.equalsIgnoreCase("wed")) {
            numberOfDay = "3";
        } else if (dayOfWeek.equalsIgnoreCase("thu")) {
            numberOfDay = "4";
        } else if (dayOfWeek.equalsIgnoreCase("fri")) {
            numberOfDay = "5";
        } else if (dayOfWeek.equalsIgnoreCase("sat")) {
            numberOfDay = "6";
        } else throw new IllegalArgumentException(String.format("%s - incorrect day of the week", dayOfWeek));

        return numberOfDay;
    }
}
