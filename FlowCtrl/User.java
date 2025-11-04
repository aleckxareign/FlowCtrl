import java.util.*;

public class User {
    String name;
    String password;
    List<Cycle> cycles = new ArrayList<>();

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
