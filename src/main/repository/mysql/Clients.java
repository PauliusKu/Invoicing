package main.repository.mysql;

import main.domain.client.Client;
import main.repository.common.IClients;

import java.util.ArrayList;
import java.util.List;

public class Clients implements IClients {

    public ArrayList<Client> getAllClients() {
        throw new java.lang.UnsupportedOperationException();
    }

    public boolean addOneClient(Client client){
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public void clear() {

    }

    @Override
    public void prepare(List<String> dataList) {

    }
}
