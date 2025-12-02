import java.util.*;

public abstract class BaseUser extends Person {
    private List<Cycle> cycles = new ArrayList<>();

    public BaseUser(String name, String password) {
        super(name, password);
    }

    public List<Cycle> getCycles() {
        return Collections.unmodifiableList(cycles);  // Encapsulation: Prevents external modification
    }

    public void addCycle(Cycle c) {
        if (c == null) throw new IllegalArgumentException("Cycle cannot be null");
        cycles.add(c);
    }

    // Abstraction: Subclasses define how to greet
    public abstract void greet();
}
