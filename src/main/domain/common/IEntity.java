package main.domain.common;

import java.util.ArrayList;

public interface IEntity {
    ArrayList<IEntity> getInnerEntitiesByType(Class<?> cls);
}
