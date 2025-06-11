package srp.clases;

public class UserRepository {
    public void save(User user) {
        System.out.println("Saving user to the database...");
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " + user.getPassword());
    }
}