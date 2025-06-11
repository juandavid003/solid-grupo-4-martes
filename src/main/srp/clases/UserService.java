package srp.clases;

public class UserService {
    private Validator validator = new Validator();
    private UserRepository repository = new UserRepository();
    private EmailService emailService = new EmailService();

    public void addUser(String email, String password) {
        if (validator.isValidEmail(email) && validator.isValidPassword(password)) {
            User user = new User(email, password);
            repository.save(user);
            emailService.sendWelcomeEmail(email);
        } else {
            System.out.println("Invalid email or password. User not added.");
        }
    }
}