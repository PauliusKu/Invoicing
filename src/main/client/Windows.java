package main.client;

import main.client.interfaces.IWindow;

import java.util.HashMap;
import java.util.Map;

public class Windows {

    private static final Map<String, IWindow> windows = new HashMap<>(){{
        put(Strings.SIGN_IN, new LoginWindow(Config.INPUT_READER, Config.OUTPUT_PRINTER));
        put(Strings.MAIN_MENU, new MainMenuWindow(Config.OUTPUT_PRINTER));
    }};

    public static IWindow GetWindow(String title) {
        return windows.get(title);
    }
}
