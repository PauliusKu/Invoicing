package main.repository.mock;

import main.domain.client.Client;
import main.repository.common.IClients;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Clients implements IClients {
    @Override
    public ArrayList<Client> getAllClients() {
        Client client = new Client();
        client.firstName = "John";
        client.lastName = "Johnson";
        client.email.email = "j.johnson@gmail.com";
        client.organisation = "Company";
        client.invoicedAmount = new BigDecimal(5500);
        client.receivedAmount = new BigDecimal(4750);

        var list = new ArrayList<Client>();
        list.add(client);
        return list;
    }
}
