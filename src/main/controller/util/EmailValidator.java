package main.controller.util;

import main.domain.common.IEntity;
import main.domain.user.Email;
import main.domain.user.UserLogin;

public class EmailValidator extends ParallelValidator{

    public EmailValidator(ParallelValidator validator){
        this.validator = validator;
    }

    public EmailValidator(){
        this.validator = null;
    }

    @Override
    protected void checkTypeAndValidate(IEntity entity) {
        Email email;
        if (!(entity instanceof Email)){
            var array = entity.getInnerEntitiesByType(IEntity.class);
            if (array.isEmpty()) {
                errorMessages.add("Password field is empty");
                return;
            }
            else email = (Email) array.get(0);
        }
        else email = (Email) entity;

        validateEmail(email);
    }

    private void validateEmail(Email email){
    }
}
