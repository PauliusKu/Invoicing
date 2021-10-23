package main.controller.common;

import main.controller.util.TokenManager;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    public static RepositoryFactory repositoryFactory = new RepositoryFactory();
    public static Map<String, Object> response;
    public static String token;

    protected static void init(){
        response = new HashMap<>();
    }

    protected static boolean authorise(String token){

        if (!TokenManager.getInstance().checkToken(token)) {
            response.put(ResponseKey.ERROR.toString(), "Unauthorized token!");
            return false;
        }

        Controller.token = token;
        return true;
    }

    protected static Map<String, Object> getMapResponse(){

        if (response.isEmpty()) {
            response.put(ResponseKey.ERROR.toString(), "Other error occurred!");
            return response;
        }
        else if (response.containsKey(ResponseKey.ERROR.toString())){
            return response;
        }

        response.put(ResponseKey.TOKEN.toString(), getNewToken());

        return response;
    }

    private static String getNewToken(){
        return TokenManager.getInstance().getNewToken(token);
    }
}
