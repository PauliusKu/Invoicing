package main.controller.common;

import main.controller.util.TokenManager;

import java.util.Map;

public class Controller {
    public static RepositoryFactory repositoryFactory = new RepositoryFactory();
    public static Map<String, String> response;
    public static String token;

    protected static boolean authorise(String token){

        if (!TokenManager.getInstance().checkToken(token))
            return false;

        Controller.token = token;
        return true;
    }

    protected static Map<String, String> getMapResponse(){

        if (response.isEmpty()) {
            response.put(ResponseKey.ERROR.toString(), "Other error occurred!");
        }

        response.put(ResponseKey.TOKEN.toString(), getNewToken());

        return response;
    }

    private static String getNewToken(){
        return TokenManager.getInstance().getNewToken(token);
    }
}
