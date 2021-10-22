package main.domain.user;

import main.domain.common.IEntity;

import java.util.ArrayList;

public class UserLogin extends User implements IEntity {
    public Password password;
    public UserType userType;

    public ArrayList<IEntity> getInnerEntitiesByType(Class<?> cls){
        var array = super.getInnerEntitiesByType(cls);

        if (cls == Password.class) {array.add(password); }
        return array;
    }
}
