import java.util.*;

public class User {
    private String name;
    private String password;
    protected List<Cycle> cycles = new ArrayList<>();

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
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
}
