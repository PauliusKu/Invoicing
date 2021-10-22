package main.controller.common;

import main.controller.interfaces.IUsersRepo;
import main.repository.mock.Users;

public class RepositoryFactory {
    public IUsersRepo getUsers(){
        return IntegrationConfig.repositoryType == RepositoryType.MYSQL ? null : new Users();
    }
}
