public class MoodCycle extends Cycle {
    public MoodCycle(String startDate, String endDate, String symptoms, String mood, int moodValue) {
        super(startDate, endDate, symptoms, mood, moodValue);
    }
    @Override
    public void displayCycleInfo(int count) {
        String enhancedMood = getMood();
        System.out.printf("%-3d | %-12s | %-12s | %-8d | %-25s | %-15s%n",
                count, getStartDate(), getEndDate(), getCycleLength(), getSymptoms(), enhancedMood);
    }
}
