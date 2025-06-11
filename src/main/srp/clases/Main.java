package srp.clases;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.addUser("example@domain.com", "password123");
        userService.addUser("invalid-email", "1234");
    }
}