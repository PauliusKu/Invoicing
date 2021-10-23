package main.controller.util;

import java.util.Objects;

public class TokenManager {

    private static TokenManager instance;
    private static String currentToken;

    private TokenManager(){
        instance = this;
    }

    public static TokenManager getInstance(){
        if(instance == null)
            return new TokenManager();
        return instance;
    }

    public String getNewToken(String prevToken){
        currentToken = "123" + prevToken;
        return currentToken;
    }

    public boolean checkToken(String token){
        return Objects.equals(token, currentToken);
    }
}
