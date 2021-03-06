package main.repository.mock;

import main.domain.client.Client;
import main.repository.common.IClients;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Clients implements IClients {

    public static ArrayList<Client> clients = new ArrayList<>();

    public ArrayList<Client> getAllClients() {
        return clients;
    }

    public boolean addOneClient(Client client){
        return  clients.add(client);
    }

    @Override
    public boolean deleteOneClient(String email) {
        int i = 0;
        int index = -1;
        for (var client : clients){
            if (Objects.equals(client.email.email, email)){
                index = i;
            }
            i++;
        }
        if (index >= 0){
            clients.remove(index);
        }
        return true;
    }

    @Override
    public void clear() {
        clients = new ArrayList<>();
    }

    @Override
    public void prepare(List<String> dataList) {
        Client client = new Client();
        client.firstName = dataList.get(0);
        client.lastName = dataList.get(1);
        client.email.email = dataList.get(2);
        client.organisation = dataList.get(3);
        client.invoicedAmount = new BigDecimal(dataList.get(4));
        client.receivedAmount = new BigDecimal(dataList.get(5));
        clients.add(client);
    }
}
