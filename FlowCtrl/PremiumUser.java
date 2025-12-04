import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PremiumUser extends User {

    public PremiumUser(String name, String password) {
        super(name, password);
    }

    @Override
    public boolean isPremium() {
        return true;
    }

    @Override
    public void displayInfo() {
        System.out.println("User: " + getName() + " (Premium Account)");
    }

    @Override
    public void greet() {
        System.out.println("Hello, " + getName() + "! As a Premium user, enjoy enhanced insights.");
    }

    public void viewHealthInsights() {
        if (getCycles().isEmpty()) {
            System.out.println("No cycle data available.");
            return;
        }

        double avgCycleLength = FlowCtrl.getAverageCycleLength(this);
        double avgDuration = FlowCtrl.getAverageDuration(this);

        int moodSum = 0;
        for (Cycle c : getCycles()) {
            moodSum += c.getMoodValue();
        }
        double avgMood = (double) moodSum / getCycles().size();

        String moodType;
        if (avgMood <= 2.0) moodType = "Positive";
        else if (avgMood <= 3.5) moodType = "Neutral";
        else moodType = "Negative";

        List<Long> intervals = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (int i = 1; i < getCycles().size(); i++) {
                Date prev = sdf.parse(getCycles().get(i - 1).getStartDate());
                Date curr = sdf.parse(getCycles().get(i).getStartDate());
                intervals.add((curr.getTime() - prev.getTime()) / (1000 * 60 * 60 * 24));
            }
        } catch (Exception e) {
            // Exception handling: Ignore parse errors to prevent crashes
        }

        double variance = 0;
        if (!intervals.isEmpty()) {
            for (Long val : intervals) variance += Math.pow(val - avgCycleLength, 2);
            variance = variance / intervals.size();
        }
        double regularityScore = Math.max(0, Math.min(100, 100 - variance));

        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.println("Hey " + getName() + ", here's your personalized health insights:");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Average cycle length: " + (int) avgCycleLength + " days");
        System.out.println("Average period duration: " + String.format("%.1f", avgDuration) + " days");
        System.out.println("Overall mood: " + moodType);
        System.out.println("Cycle regularity score: " + String.format("%.1f", regularityScore) + "/100");

        String tip;
        switch (moodType) {
            case "Positive":
                tip = "You seem to be in a good rhythm! Keep doing what makes you feel this balanced.";
                break;
            case "Negative":
                tip = "Your recent moods show some stress or fatigue. Try slowing down, hydrating, or taking time for yourself.";
                break;
            default:
                tip = "Your mood's holding steady! Keep tuning in to yourself, staying mindful helps you maintain balance.";
                break;
        }
        System.out.println("\nHealth Tip Based on Your Overall Mood:");
        System.out.println(tip);
        System.out.println("----------------------------------------------------------------------------------------------");
    }
}
