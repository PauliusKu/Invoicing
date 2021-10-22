package main.controller.access;
import main.controller.common.Controller;
import main.controller.interfaces.IUsersRepo;
import main.controller.util.EmailValidator;
import main.controller.util.LoginValidator;
import main.domain.user.UserDetails;
import main.domain.user.UserLogin;

public class LoginController extends Controller {

    private static final IUsersRepo usersRepo = repositoryFactory.getUsers();

    public static String login(String email, String password) {
        UserLogin userLogin = new UserLogin();
        userLogin.email.email = email;
        userLogin.password.password = password;

        UserDetails userDetails = usersRepo.getUserByEmail(userLogin.email);

        var validator = new LoginValidator(new EmailValidator(), userDetails);
        validator.validate(userLogin);

        var errors = validator.getErrorMessages();

        if(errors.isEmpty())
            return "Success: you are logged in";

        return errors.toString();
    }
}
