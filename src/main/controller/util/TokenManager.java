package main.controller.util;

public class TokenManager {

    private static TokenManager instance;

    private TokenManager(){
        instance = this;
    }

    public static TokenManager getInstance(){
        if(instance == null)
            return new TokenManager();
        return instance;
    }

    public String getNewToken(String prevToken){
       return "123" + prevToken;
    }

    public boolean checkToken(String token){
        return true;
    }
}
