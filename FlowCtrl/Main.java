import java.util.*;
import java.text.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Map<String, User> users = new HashMap<>();
    static User loggedInUser = null;
    static boolean firstRun = true;

    public static void main(String[] args) {
        while (true) {
            try {
                if (firstRun) {
                    System.out.println("========================================");
                    System.out.println("         Welcome to FlowCtrl! ");
                    System.out.println("     Your Personal Cycle Companion");
                    System.out.println("    Track your period, log symptoms,");
                    System.out.println("   and understand your rhythm better.");
                    System.out.println("========================================");
                    firstRun = false;
                } else {
                    System.out.println("========================================");
                    System.out.println("         Welcome to FlowCtrl! ");
                    System.out.println("     Your Personal Cycle Companion");
                    System.out.println("========================================");
                }

                System.out.println("[1] Sign Up");
                System.out.println("[2] Log In");
                System.out.println("[3] Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    signUp();
                } else if (choice == 2) {
                    login();
                } else if (choice == 3) {
                    System.out.println("Goodbye! Remember: flow with kindness.");
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1-3.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
    }

    static void signUp() {
        System.out.println("\n=== SIGN UP ===");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Create a password: ");
        String password = sc.nextLine();
        System.out.print("Confirm password: ");
        String confirm = sc.nextLine();

        if (!password.equals(confirm)) {
            System.out.println("Passwords do not match. Try again.");
            return;
        }
        if (users.containsKey(name)) {
            System.out.println("Username already exists.");
            return;
        }

        users.put(name, new User(name, password));
        System.out.println("Account created successfully! You may now log in.\n");
    }

    static void login() {
        System.out.println("\n=== LOG IN ===");
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        User user = users.get(name);
        if (user != null && user.password.equals(password)) {
            loggedInUser = user;
            System.out.println("Login successful. Welcome, " + name + "!");
            mainMenu();
        } else {
            System.out.println("Invalid name or password.\n");
        }
    }

    static void mainMenu() {
        while (true) {
            try {
                System.out.println("========================================");
                System.out.println("                FlowCtrl         ");
                System.out.println("========================================");
                System.out.println("[1] Add New Cycle");
                System.out.println("[2] View Cycle History");
                System.out.println("[3] View Health Insights");
                System.out.println("[4] Predict Next Cycle");
                System.out.println("[5] Logout");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addCycle();
                        break;
                    case 2:
                        viewCycleHistory();
                        break;
                    case 3:
                        viewHealthInsights();
                        break;
                    case 4:
                        predictNextCycle();
                        break;
                    case 5:
                        System.out.println("Logging out...");
                        System.out.println("Take care, " + loggedInUser.name + "! Remember: flow with kindness.\n");
                        loggedInUser = null;
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
    }

    static void addCycle() {
        System.out.println("\n==== Add New Cycle ====");
        System.out.print("Enter start date (YYYY-MM-DD): ");
        String start = sc.nextLine();
        System.out.print("Enter end date (YYYY-MM-DD): ");
        String end = sc.nextLine();
        System.out.print("Enter symptoms (comma-separated): ");
        String symptoms = sc.nextLine();

        System.out.println("Select mood (1-5):");
        System.out.println("1 - Very Positive ");
        System.out.println("2 - Positive");
        System.out.println("3 - Neutral");
        System.out.println("4 - Negative");
        System.out.println("5 - Very Negative");
        System.out.print("Choice: ");

        int moodChoice = 3;
        try {
            moodChoice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Defaulting to Neutral.");
            sc.nextLine();
        }
        sc.nextLine();

        String mood = getMoodString(moodChoice);

        loggedInUser.cycles.add(new Cycle(start, end, symptoms, mood, moodChoice));
        System.out.println("Cycle recorded successfully!");
    }

    static void viewCycleHistory() {
        System.out.println("\n===================================================================================");
        System.out.println("      Cycle History for " + loggedInUser.name);
        System.out.println("=====================================================================================");
        System.out.printf("%-3s | %-12s | %-12s | %-8s | %-25s | %-15s%n",
                "#", "Start Date", "End Date", "Duration", "Symptoms", "Mood");
        System.out.println("-------------------------------------------------------------------------------------");

        if (loggedInUser.cycles.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        int count = 1;
        for (Cycle c : loggedInUser.cycles) {
            System.out.printf("%-3d | %-12s | %-12s | %-8d | %-25s | %-15s%n",
                    count, c.startDate, c.endDate, c.getCycleLength(), c.symptoms, c.mood);
            count++;
        }
    }

    static void viewHealthInsights() {
        if (loggedInUser.cycles.isEmpty()) {
            System.out.println("No cycle data available.");
            return;
        }

        double avgCycleLength = getAverageCycleLength();
        double avgDuration = getAverageDuration();
        String allSymptoms = getAllSymptoms();


        int moodSum = 0;
        for (Cycle c : loggedInUser.cycles) {
            moodSum += c.moodValue;
        }
        double avgMood = (double) moodSum / loggedInUser.cycles.size();

        String moodType;
        String tip;

        if (avgMood <= 2.0) {
            moodType = "Positive";
            tip = "You seem to be in a good rhythm! Keep doing what makes you feel this balanced.";
        } else if (avgMood <= 3.5) {
            moodType = "Neutral";
            tip = "Your mood's been steady. Keep tracking — awareness helps you stay balanced.";
        } else {
            moodType = "Negative";
            tip = "Your recent moods show some stress or fatigue. Try slowing down, hydrating, or taking time for yourself.";
        }

        System.out.println("\n-------------------------------------------------------------------------------------------------------------");
        System.out.println("Hey " + loggedInUser.name + ", here's how your body's been doing.");
        System.out.println("Average cycle length: " + (int) avgCycleLength + " days");
        System.out.println("Average period duration: " + String.format("%.1f", avgDuration) + " days");
        System.out.println("Symptoms: " + allSymptoms);
        System.out.println("Overall mood: " + moodType);
        System.out.println("Tip: " + tip);
        System.out.println("-------------------------------------------------------------------------------------------------------------");
    }

    static double getAverageCycleLength() {
        if (loggedInUser.cycles.size() < 2) return 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            List<Long> differences = new ArrayList<Long>();
            for (int i = 1; i < loggedInUser.cycles.size(); i++) {
                Date prev = sdf.parse(loggedInUser.cycles.get(i - 1).startDate);
                Date current = sdf.parse(loggedInUser.cycles.get(i).startDate);
                long diff = current.getTime() - prev.getTime();
                differences.add(diff / (1000 * 60 * 60 * 24));
            }
            double total = 0;
            for (Long d : differences) total += d;
            return total / differences.size();
        } catch (Exception e) {
            return 0;
        }
    }

    static double getAverageDuration() {
        if (loggedInUser.cycles.isEmpty()) return 0;
        int total = 0;
        for (Cycle c : loggedInUser.cycles) total += c.getCycleLength();
        return (double) total / loggedInUser.cycles.size();
    }

    static String getAllSymptoms() {
    Set<String> allSymptoms = new LinkedHashSet<>(); // keeps order, avoids duplicates
    for (Cycle c : loggedInUser.cycles) {
        String[] list = c.symptoms.split(",");
        for (String s : list) {
            String trimmed = s.trim().toLowerCase();
            if (!trimmed.isEmpty()) {
                allSymptoms.add(trimmed);
            }
        }
    }

    if (allSymptoms.isEmpty()) {
        return "None";
    }

    return String.join(", ", allSymptoms);
}

    static String getMoodString(int choice) {
        switch (choice) {
            case 1: return "Very Positive";
            case 2: return "Positive";
            case 3: return "Neutral";
            case 4: return "Negative";
            case 5: return "Very Negative";
            default: return "Neutral";
        }
    }

    static void predictNextCycle() {
        if (loggedInUser.cycles.size() < 1) {
            System.out.println("Not enough data to predict your next cycle.");
            return;
        }

        double avgCycleLength = getAverageCycleLength();
        if (avgCycleLength == 0) {
            System.out.println("Unable to calculate average cycle length.");
            return;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Cycle lastCycle = loggedInUser.cycles.get(loggedInUser.cycles.size() - 1);
            Date lastStart = sdf.parse(lastCycle.startDate);

            Calendar cal = Calendar.getInstance();
            cal.setTime(lastStart);
            cal.add(Calendar.DAY_OF_MONTH, (int) Math.round(avgCycleLength));

            String predictedStart = sdf.format(cal.getTime());

            System.out.println("\n--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Calculating average cycle length...");
            System.out.println("Average cycle length: " + (int) avgCycleLength + " days");
            System.out.println("Your next period is likely to start on: " + predictedStart);
            System.out.println("This system provides estimates only. Predictions are not 100% accurate and should not replace professional medical advice.");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Error calculating prediction.");
        }
    }
}
