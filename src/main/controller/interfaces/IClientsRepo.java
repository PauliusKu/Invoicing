package main.controller.interfaces;

import main.domain.client.Client;

import java.util.ArrayList;

public interface IClientsRepo {

    ArrayList<Client> getAllClients();
    boolean addOneClient(Client client);
    boolean deleteOneClient(String email);
}
