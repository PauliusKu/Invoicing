package main.client;

import main.client.interfaces.IWindow;

import java.util.HashMap;
import java.util.Map;

public class Windows {
    private static final Map<String, IWindow> WINDOWS = new HashMap<>(){{
        put(Strings.SIGN_IN, new LoginWindow(Config.INPUT_READER, Config.OUTPUT_PRINTER));
    }};
    public static IWindow GetWindow(String title) {
        return WINDOWS.get(title);
    }
}
