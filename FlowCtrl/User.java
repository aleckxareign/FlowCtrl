import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    protected List<Cycle> cycles = new ArrayList<>();

    public User(String name, String password) {
        super(name, password);
    }

    public List<Cycle> getCycles() {
        return cycles;
    }

    public void addCycle(Cycle cycle) {
        cycles.add(cycle);
    }

    public boolean isPremium() {
        return false;
    }

    @Override
    public void displayInfo() {
        System.out.println("User: " + getName() + " (Standard Account)");
    }
}
