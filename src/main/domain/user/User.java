package main.domain.user;

import main.domain.common.IEntity;

import java.util.ArrayList;

public class User implements IEntity {
    public Email email;

    public User() {
        this.email = new Email();
    }

    public ArrayList<IEntity> getInnerEntitiesByType(Class<?> cls){
        var array = new ArrayList<IEntity>();

        if (cls == Email.class) {array.add(email); }
        return array;
    }
}
