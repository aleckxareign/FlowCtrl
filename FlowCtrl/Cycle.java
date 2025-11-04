import java.text.*;
import java.util.*;

public class Cycle {
    String startDate;
    String endDate;
    String symptoms;
    String mood;
    int moodValue;

    public Cycle(String startDate, String endDate, String symptoms, String mood, int moodValue) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.symptoms = symptoms;
        this.mood = mood;
        this.moodValue = moodValue;
    }

    public int getCycleLength() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date start = sdf.parse(startDate);
            Date end = sdf.parse(endDate);
            long diff = end.getTime() - start.getTime();
            return (int) (diff / (1000 * 60 * 60 * 24)) + 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
