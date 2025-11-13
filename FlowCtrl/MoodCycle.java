public class MoodCycle extends Cycle {

    public MoodCycle(String startDate, String endDate, String symptoms, String mood, int moodValue) {
        super(startDate, endDate, symptoms, mood, moodValue);
    }

    // Polymorphism: overriding display method
    @Override
    public void displayCycleInfo(int count) {
        super.displayCycleInfo(count);
    }
}
