package ByComs.Twitter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by JMYE on 8/7/17.
 */
public class SearchLogFile {
    public Collection<String> search(Collection<String> logLines, LocalTime startDate, LocalTime endDate) {
        List<String> result = new ArrayList<String>();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        boolean inRange = false;
        for(String line: logLines)
        {
            String[] input = line.split("\\s+");
            try
            {
                LocalTime time = LocalTime.parse(input[0], formatter);
                String s1 = startDate.toString();
                String s = time.toString();
                if(s.equals(s1) || (time.isAfter(startDate) && time.isBefore(endDate)))
                {
                    inRange = true;
                    result.add(line);
                }
                else
                {
                    inRange = false;
                }
            }
            catch(Exception e)
            {
                if(inRange) result.add(line);
            }

        }
        return result;
    }
}
