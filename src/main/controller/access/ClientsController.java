package main.controller.access;

import main.controller.common.Controller;
import main.controller.common.ResponseKey;
import main.controller.interfaces.IClientsRepo;
import main.domain.client.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientsController extends Controller {

    private static final IClientsRepo clientsRepo = repositoryFactory.getClients();

    public static Map<String, Object> addClient(String token, List<String> clientRecord){
        init();
        if (authorise(token))
            addClient(clientRecord);
        return getMapResponse();
    }

    public static Map<String, Object> getClients(String token) {
        init();
        if (authorise(token))
            collectClients();
        return getMapResponse();
    }

    private static void addClient(List<String> clientRecord){
        if(clientRecord.size() != 4){
            response.put(ResponseKey.ERROR.toString(), "Incorrect input format");
            return;
        }

        if (!isClientRecordValid(clientRecord)){
            return;
        }

        Client client = new Client();
        client.firstName = clientRecord.get(0);
        client.lastName = clientRecord.get(1);
        client.email.email = clientRecord.get(2);
        client.organisation = clientRecord.get(3);

        var clientsList = clientsRepo.getAllClients();
        for(var clientToCheck : clientsList){
            if (client.equals(clientToCheck)){
                response.put(ResponseKey.ERROR.toString(), "This client is already present");
                return;
            }
        }

        if (!clientsRepo.addOneClient(client)){
            response.put(ResponseKey.ERROR.toString(), "Database error. Client was not created");
            return;
        }

        response.put(ResponseKey.MESSAGE.toString(), "Success: Client was added");
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

    private static boolean isClientRecordValid(List<String> clientRecord){
        if (clientRecord.get(0).isBlank()){
            response.put(ResponseKey.ERROR.toString(), "Error occurred: [Empty first name]");
            return false;
        }

        if (clientRecord.get(1).isBlank()){
            response.put(ResponseKey.ERROR.toString(), "Error occurred: [Empty last name]");
            return false;
        }

        if (clientRecord.get(2).isBlank()){
            response.put(ResponseKey.ERROR.toString(), "Error occurred: [Empty email]");
            return false;
        }

        if (clientRecord.get(3).isBlank()){
            response.put(ResponseKey.ERROR.toString(), "Error occurred: [Empty organisation]");
            return false;
        }

        return true;
    }
}
