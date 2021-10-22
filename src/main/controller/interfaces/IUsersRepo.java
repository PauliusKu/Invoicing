package main.controller.interfaces;

import main.domain.user.Email;
import main.domain.user.UserDetails;

public interface IUsersRepo {
    UserDetails getUserByEmail(Email email);
}
