package main.repository.mock;

import main.domain.client.Client;
import main.repository.common.IClients;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Clients implements IClients {

    public static ArrayList<Client> clients = new ArrayList<>();

    public Clients(){
        if (clients.isEmpty()) {
            Client client = new Client();
            client.firstName = "John";
            client.lastName = "Johnson";
            client.email.email = "j.johnson@gmail.com";
            client.organisation = "Company";
            client.invoicedAmount = new BigDecimal(5500);
            client.receivedAmount = new BigDecimal(4750);
            clients.add(client);
        }
    }

    public ArrayList<Client> getAllClients() {
        return clients;
    }

    public boolean addOneClient(Client client){
        return  clients.add(client);
    }
}
