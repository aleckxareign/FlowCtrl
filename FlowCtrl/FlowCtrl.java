import java.util.*;
import java.text.*;

public class FlowCtrl {

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

    String type;
    while (true) {
        System.out.print("Do you want a Premium account? (yes/no): ");
        type = sc.nextLine().trim();  
        if (type.equalsIgnoreCase("yes") || type.equalsIgnoreCase("no")) {
            break;  
        } else {
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }
    }

    User newUser;
    if (type.equalsIgnoreCase("yes")) {
        newUser = new PremiumUser(name, password);
    } else {
        newUser = new User(name, password);
    }

    users.put(name, newUser);
    System.out.println("Account created successfully! You may now log in.\n");
}

    static void login() {
    System.out.println("\n=== LOG IN ===");
    System.out.print("Enter name: ");
    String name = sc.nextLine();
    System.out.print("Enter password: ");
    String password = sc.nextLine();

    User user = users.get(name);
    if (user != null && user.getPassword().equals(password)) {
        loggedInUser = user;
        System.out.println("Login successful. Welcome, " + name + "!");
        loggedInUser.displayInfo();  
        loggedInUser.greet();  
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

                if (choice == 1) {
                    addCycle();
                } else if (choice == 2) {
                    viewCycleHistory();
                } else if (choice == 3) {
                    if (loggedInUser.isPremium()) {
                        ((PremiumUser) loggedInUser).viewHealthInsights();
                    } else {
                        System.out.println("\nThis feature is available for Premium users only.");
                        System.out.println("Upgrade to Premium to access personalized health insights.\n");
                    }
                } else if (choice == 4) {
                    predictNextCycle();
                } else if (choice == 5) {
                    System.out.println("Logging out...");
                    System.out.println("You're all set, " + loggedInUser.getName() + "! Wishing you balance and calm today.");
                    loggedInUser = null;
                    return;
                } else {
                    System.out.println("Invalid choice.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
    }

static void addCycle() {
    System.out.println("\n--- Add New Cycle ---");
    
    String start;
    while (true) {
        System.out.print("Enter start date (YYYY-MM-DD): ");
        start = sc.nextLine().trim();
        if (isValidDate(start)) {
            break;
        } else {
            System.out.println("Invalid date format or value. Please enter a valid date in YYYY-MM-DD format.");
        }
    }
    
    String end;
    while (true) {
        System.out.print("Enter end date (YYYY-MM-DD): ");
        end = sc.nextLine().trim();
        if (isValidDate(end)) {
            break;
        } else {
            System.out.println("Invalid date format or value. Please enter a valid date in YYYY-MM-DD format.");
        }
    }
    
    System.out.print("Enter symptoms (comma-separated): ");
    String symptoms = sc.nextLine();

    System.out.println("Select mood (1-5):");
    System.out.println("1 - Very Positive ");
    System.out.println("2 - Positive");
    System.out.println("3 - Neutral");
    System.out.println("4 - Negative");
    System.out.println("5 - Very Negative");
    

    int moodChoice;
    while (true) {
        System.out.print("Choice: ");
        try {
            moodChoice = sc.nextInt();
            if (moodChoice >= 1 && moodChoice <= 5) {
                break;  
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number between 1 and 5.");
            sc.nextLine(); 
        }
    }
    sc.nextLine();  

    String mood = getMoodString(moodChoice);
    loggedInUser.addCycle(new MoodCycle(start, end, symptoms, mood, moodChoice));
    System.out.println("Cycle recorded successfully!");
}

        static boolean isValidDate(String dateStr) {
        if (dateStr == null || !dateStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return false;  
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);  
            sdf.parse(dateStr);  
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static void viewCycleHistory() {
        System.out.println("\n=====================================================================================================");
        System.out.println("                             Cycle History for " + loggedInUser.getName());
        System.out.println("=====================================================================================================");
        System.out.printf("%-3s | %-12s | %-12s | %-8s | %-25s | %-15s%n",
                "#", "Start Date", "End Date", "Duration", "Symptoms", "Mood");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        if (loggedInUser.getCycles().isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        int count = 1;
        for (Cycle c : loggedInUser.getCycles()) {
            c.displayCycleInfo(count);  
            count++;
        }
    }

    static void predictNextCycle() {
        if (loggedInUser.getCycles().size() < 1) {
            System.out.println("Not enough data to predict your next cycle.");
            return;
        }

        double avgCycleLength = getAverageCycleLength(loggedInUser);
        double avgDuration = getAverageDuration(loggedInUser);

        if (avgCycleLength == 0) {
            System.out.println("Unable to calculate average cycle length.");
            return;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Cycle lastCycle = loggedInUser.getCycles().get(loggedInUser.getCycles().size() - 1);
            Date lastStart = sdf.parse(lastCycle.getStartDate());

            Calendar cal = Calendar.getInstance();
            cal.setTime(lastStart);
            cal.add(Calendar.DAY_OF_MONTH, (int) Math.round(avgCycleLength));

            String predictedStart = sdf.format(cal.getTime());

            System.out.println("\n------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Calculating average cycle length...");
            System.out.println("Average cycle length: " + (int) avgCycleLength + " days");
            System.out.println("Your next period is likely to start on: " + predictedStart);
            System.out.println("------------------------------------------------------------------------------------------------------------------------");

            System.out.println("\nPredicted Menstrual Phases Based on Your Average Data:");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.printf("%-20s | %-15s | %-15s%n", "Phase", "Start Date", "End Date");
            System.out.println("-------------------------------------------------------------------------------------");

            // Compute cycle stability (variance)
            List<Long> intervals = new ArrayList<Long>();
            for (int i = 1; i < loggedInUser.getCycles().size(); i++) {
                Date prev = sdf.parse(loggedInUser.getCycles().get(i - 1).getStartDate());
                Date curr = sdf.parse(loggedInUser.getCycles().get(i).getStartDate());
                intervals.add((curr.getTime() - prev.getTime()) / (1000 * 60 * 60 * 24));
            }

            double variance = 0;
            if (!intervals.isEmpty()) {
                for (Long val : intervals) variance += Math.pow(val - avgCycleLength, 2);
                variance = variance / intervals.size();
            }

            // Adaptive phase percentages
            double stabilityFactor = variance < 9 ? 1.0 : (variance < 25 ? 0.9 : 0.8);
            double follicularPercent = 0.45 * stabilityFactor;
            double ovulationPercent = 0.05;
            double lutealPercent = 1 - follicularPercent - ovulationPercent;

            int menstrualLength = (int) Math.round(avgDuration);
            int follicularLength = (int) Math.max(1, Math.round(avgCycleLength * follicularPercent) - menstrualLength);
            int ovulationLength = (int) Math.max(1, Math.round(avgCycleLength * ovulationPercent));
            int lutealLength = (int) Math.max(1, Math.round(avgCycleLength * lutealPercent) - ovulationLength);

            Calendar phaseCal = Calendar.getInstance();
            phaseCal.setTime(sdf.parse(predictedStart));

            // Menstrual Phase
            Date menstrualStart = phaseCal.getTime();
            phaseCal.add(Calendar.DAY_OF_MONTH, menstrualLength - 1);
            Date menstrualEnd = phaseCal.getTime();
            System.out.printf("%-20s | %-15s | %-15s%n",
                    "Menstrual", sdf.format(menstrualStart), sdf.format(menstrualEnd));

            // Follicular Phase
            phaseCal.add(Calendar.DAY_OF_MONTH, 1);
            Date follicularStart = phaseCal.getTime();
            phaseCal.add(Calendar.DAY_OF_MONTH, follicularLength - 1);
            Date follicularEnd = phaseCal.getTime();
            System.out.printf("%-20s | %-15s | %-15s%n",
                    "Follicular", sdf.format(follicularStart), sdf.format(follicularEnd));

            // Ovulation Phase
            phaseCal.add(Calendar.DAY_OF_MONTH, 1);
            Date ovulationStart = phaseCal.getTime();
            phaseCal.add(Calendar.DAY_OF_MONTH, ovulationLength - 1);
            Date ovulationEnd = phaseCal.getTime();
            System.out.printf("%-20s | %-15s | %-15s%n",
                    "Ovulation", sdf.format(ovulationStart), sdf.format(ovulationEnd));

            // Luteal Phase
            phaseCal.add(Calendar.DAY_OF_MONTH, 1);
            Date lutealStart = phaseCal.getTime();
            phaseCal.add(Calendar.DAY_OF_MONTH, lutealLength - 1);
            Date lutealEnd = phaseCal.getTime();
            System.out.printf("%-20s | %-15s | %-15s%n",
                    "Luteal", sdf.format(lutealStart), sdf.format(lutealEnd));

            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("\nNote: These predictions are based on statistical estimations from your recorded data.");
            System.out.println("They are not guaranteed to be accurate and should not replace professional medical consultation.");
            System.out.println("This tool is intended to assist with personal tracking and awareness only.");
            System.out.println("-------------------------------------------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Error calculating prediction.");
        }
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

    static double getAverageCycleLength(User user) {
        if (user.getCycles().size() < 2) return 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            List<Long> differences = new ArrayList<Long>();
            for (int i = 1; i < user.getCycles().size(); i++) {
                Date prev = sdf.parse(user.getCycles().get(i - 1).getStartDate());
                Date current = sdf.parse(user.getCycles().get(i).getStartDate());
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

    static double getAverageDuration(User user) {
        if (user.getCycles().isEmpty()) return 0;
        int total = 0;
        for (Cycle c : user.getCycles()) total += c.getCycleLength();
        return (double) total / user.getCycles().size();
    }

    static String getMostCommonSymptom(User user) {
        Map<String, Integer> symptomCount = new HashMap<String, Integer>();
        for (Cycle c : user.getCycles()) {
            String[] list = c.getSymptoms().split(",");
            for (String s : list) {
                String trimmed = s.trim().toLowerCase();
                symptomCount.put(trimmed, symptomCount.getOrDefault(trimmed, 0) + 1);
            }
        }

        String mostCommon = "None";
        int max = 0;
        for (Map.Entry<String, Integer> entry : symptomCount.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mostCommon = entry.getKey();
            }
        }
        return mostCommon;
    }
}
