package main.repository.mock;

import main.repository.common.IUsers;
import main.domain.user.Email;
import main.domain.user.UserDetails;

public class Users implements IUsers {

    public UserDetails getUserByEmail(Email email) {
        UserDetails userDetails = new UserDetails();
        userDetails.email.email = "admin";
        userDetails.password.password = "admin";
        return userDetails;
    }
}
