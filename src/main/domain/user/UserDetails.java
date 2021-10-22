package main.domain.user;

import main.domain.common.IEntity;

import java.util.ArrayList;

public class UserDetails extends User implements IEntity {
    public int userId;
    public Password password;
    public UserType userType;
    public String UserName;

    public UserDetails() {
        this.password = new Password();
    }

    public ArrayList<IEntity> getInnerEntitiesByType(Class<?> cls){
        var array = super.getInnerEntitiesByType(cls);

        if (cls == Password.class) {array.add(password); }
        return array;
    }
}
