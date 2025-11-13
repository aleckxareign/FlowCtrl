import java.util.*;

abstract class BaseUser {
    private String name;
    private String password;
    protected List<Cycle> cycles = new ArrayList<>();

    public BaseUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Encapsulation
    public String getName() { return name; }
    public String getPassword() { return password; }
    public List<Cycle> getCycles() { return cycles; }

    public void addCycle(Cycle c) {
        cycles.add(c);
    }

    // Abstract method (for polymorphic greeting)
    public abstract void greet();
}
