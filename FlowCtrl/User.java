public class User extends BaseUser {  // Fixed: Now extends BaseUser for proper inheritance
    // Removed redundant cycles list and addCycle method (inherited from BaseUser)
    public User(String name, String password) {
        super(name, password);
    }
    // Abstraction/Polymorphism: Implements the abstract greet() method from BaseUser
    @Override
    public void greet() {
        System.out.println("Hello, " + getName() + "! Welcome to FlowCtrl.");
    }
    public boolean isPremium() {
        return false;
    }
    @Override
    public void displayInfo() {
        System.out.println("User: " + getName() + " (Standard Account)");
    }
}
