
package main.repository.mysql;

import main.repository.common.IUsers;
import main.domain.user.Email;
import main.domain.user.UserDetails;

public class Users implements IUsers {

    public UserDetails getUserByEmail(Email email) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public void clear() {

    }
}