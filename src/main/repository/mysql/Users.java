
package main.repository.mysql;

import main.repository.common.IUsers;
import main.domain.user.Email;
import main.domain.user.UserDetails;

import java.util.List;

public class Users implements IUsers {

    public UserDetails getUserByEmail(Email email) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public void clear() {

    }

    @Override
    public void prepare(List<String> dataList) {

    }
}