package main.controller.util;

import main.domain.common.IEntity;
import main.domain.user.Email;
import main.domain.user.Password;
import main.domain.user.UserDetails;
import main.domain.user.UserLogin;

import java.util.Objects;

public class LoginValidator extends ParallelValidator{
    public UserDetails userDetails;

    public LoginValidator(ParallelValidator validator, UserDetails userDetails){
        this.validator = validator;
        this.userDetails = userDetails;
    }

    @Override
    protected void checkTypeAndValidate(IEntity entity) {
        if (!(entity instanceof UserLogin userLogin)){
            errorMessages.add("Password field is empty");
            return;
        }

        validatePasswordLength(userLogin.password);
        validatePasswordAgainstGivenUser(userLogin);
    }


    private void validatePasswordLength(Password password){
        if (password.password.length() < 8){
            errorMessages.add("Password field is too short");
            return;
        }

        if (password.password.length() > 32){
            errorMessages.add("Password field is too long");
        }
    }

    private void validatePasswordAgainstGivenUser(UserLogin userLogin){
        if (!(userLogin.email == userDetails.email && Objects.equals(userLogin.password.password, userDetails.password.password))){
            errorMessages.add("Wrong email or password");
        }
    }
}
