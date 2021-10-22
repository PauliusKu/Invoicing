package main.controller.util;

import main.domain.common.IEntity;

import java.util.ArrayList;

public abstract class ParallelValidator {

    protected ArrayList<String> errorMessages = new ArrayList<>();
    protected ParallelValidator validator;

    public void validate(IEntity entity){
        checkTypeAndValidate(entity);
        validator.validate(entity);
    }

    public ArrayList<String> getErrorMessages(){
        return errorMessages;
    }

    protected abstract void checkTypeAndValidate(IEntity entity);
}
