import java.text.*;
import java.util.*;

public class Cycle {
    private String startDate;
    private String endDate;
    private String symptoms;
    private String mood;
    private int moodValue;

    public Cycle(String startDate, String endDate, String symptoms, String mood, int moodValue) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.symptoms = symptoms;
        this.mood = mood;
        this.moodValue = moodValue;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getMood() {
        return mood;
    }

    public int getMoodValue() {
        return moodValue;
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

    // Added for polymorphism: Base display method that subclasses can override
    public void displayCycleInfo(int count) {
        System.out.printf("%-3d | %-12s | %-12s | %-8d | %-25s | %-15s%n",
                count, getStartDate(), getEndDate(), getCycleLength(), getSymptoms(), getMood());
    }
}
