package main.controller.common;

import main.controller.interfaces.IClientsRepo;
import main.controller.interfaces.IUsersRepo;
import main.repository.mock.Clients;
import main.repository.mock.Users;

public class RepositoryFactory {
    public IUsersRepo getUsers(){
        return IntegrationConfig.REPOSITORYTYPE == RepositoryType.MYSQL ? new main.repository.mysql.Users() : new Users();
    }

    public IClientsRepo getClients(){
        return IntegrationConfig.REPOSITORYTYPE == RepositoryType.MYSQL ? new main.repository.mysql.Clients() : new Clients();
    }
}
