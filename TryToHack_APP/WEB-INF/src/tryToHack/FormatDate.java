package tryToHack;

import java.text.*;
import java.util.Date;

public class FormatDate
{
    private static SimpleDateFormat formatAMJ;
    static
    {
        formatAMJ = new SimpleDateFormat("yyyy-MM-dd");
        formatAMJ.setLenient(false);
    }

    public static Date convertirDate(String dateString) throws ParseException
    {
        return formatAMJ.parse(dateString);
    }

    public static String toString(Date date)
    {
        return formatAMJ.format(date);
    }
}
