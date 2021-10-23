package main.controller.access;

import main.controller.common.Controller;
import main.controller.common.RepositoryType;
import main.controller.common.ResponseKey;
import main.controller.interfaces.IClientsRepo;

import java.util.ArrayList;
import java.util.Map;

public class ClientsController extends Controller {

    private static final IClientsRepo clientsRepo = repositoryFactory.getClients();

    public static Map<String, Object> getClients(String token) {
        if (authorise(token))
            collectClients();
        return getMapResponse();
    }

    private static void collectClients(){
        var clientsList = clientsRepo.getAllClients();

        ArrayList<ArrayList<String>> table = new ArrayList<>();

        for(var client : clientsList){
            ArrayList<String> clientRecord = new ArrayList<>();
            clientRecord.add(client.firstName);
            clientRecord.add(client.lastName);
            clientRecord.add(client.email.email);
            clientRecord.add(client.organisation);
            clientRecord.add(client.invoicedAmount.toString());
            clientRecord.add(client.receivedAmount.toString());

            table.add(clientRecord);
        }

        response.put(ResponseKey.TABLE.toString(), table);
    }
}
