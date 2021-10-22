package main.domain.user;
import main.domain.common.IEntity;

import java.util.ArrayList;

public class Email implements IEntity {
    public String email;

    public ArrayList<IEntity> getInnerEntitiesByType(Class<?> cls){
        return new ArrayList<>();
    }
}
