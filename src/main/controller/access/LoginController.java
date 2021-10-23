package main.controller.access;
import main.controller.common.Controller;
import main.controller.common.ResponseKey;
import main.controller.interfaces.IUsersRepo;
import main.controller.util.EmailValidator;
import main.controller.util.LoginValidator;
import main.domain.user.UserDetails;
import main.domain.user.UserLogin;

import java.util.HashMap;
import java.util.Map;

public class LoginController extends Controller {

    private static final IUsersRepo usersRepo = repositoryFactory.getUsers();

    public static Map<String, Object> login(String email, String password) {
        doLogin(email, password);
        return getMapResponse();
    }

    private static void doLogin(String email, String password){
        UserLogin userLogin = new UserLogin();
        userLogin.email.email = email;
        userLogin.password.password = password;

        UserDetails userDetails = usersRepo.getUserByEmail(userLogin.email);

        var validator = new LoginValidator(new EmailValidator(), userDetails);
        validator.validate(userLogin);

        var errors = validator.getErrorMessages();

        response = new HashMap<>();

        if(!errors.isEmpty()){
            response.put(ResponseKey.ERROR.toString(), "Error occurred: " + errors);
            return;
        }

        response.put(ResponseKey.MESSAGE.toString(), "Success: you are logged in");
    }
}
