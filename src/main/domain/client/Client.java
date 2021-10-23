package main.domain.client;

import main.domain.common.IEntity;
import main.domain.user.Email;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class Client implements IEntity {
    public String firstName;
    public String lastName;
    public Email email;
    public String organisation;
    public BigDecimal invoicedAmount;
    public BigDecimal receivedAmount;

    public Client() {
        email = new Email();
        invoicedAmount = new BigDecimal(0);
        receivedAmount = new BigDecimal(0);
    }

    @Override
    public ArrayList<IEntity> getInnerEntitiesByType(Class<?> cls) {
        var array = new ArrayList<IEntity>();

        if (cls == Email.class) {array.add(email); }
        return array;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(email, client.email);
    }

}
