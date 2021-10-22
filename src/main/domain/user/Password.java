package main.domain.user;

import main.domain.common.IEntity;

import java.util.ArrayList;

public class Password implements IEntity {
    public String password;

    public ArrayList<IEntity> getInnerEntitiesByType(Class<?> cls){
        return new ArrayList<>();
    }
}
