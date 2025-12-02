public class MoodCycle extends Cycle {

    public MoodCycle(String startDate, String endDate, String symptoms, String mood, int moodValue) {
        super(startDate, endDate, symptoms, mood, moodValue);
    }

    @Override
    public void displayCycleInfo(int count) {
        System.out.println("=== MoodCycle Details ===");
        super.displayCycleInfo(count);
        System.out.println("------------------------");
    }
}
