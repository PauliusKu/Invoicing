package main.repository.mock;

import main.repository.common.IUsers;
import main.domain.user.Email;
import main.domain.user.UserDetails;

import java.util.List;

public class Users implements IUsers {

    public static UserDetails userDetails;

    public UserDetails getUserByEmail(Email email) {
        return userDetails;
    }

    @Override
    public void clear() {

    }

    @Override
    public void prepare(List<String> dataList) {
        userDetails = new UserDetails();
        userDetails.email.email = dataList.get(0);
        userDetails.password.password = dataList.get(1);
    }
}
