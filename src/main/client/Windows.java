package main.client;

import main.client.interfaces.IWindow;

import java.util.HashMap;
import java.util.Map;

public class Windows {

    private static final Map<String, IWindow> windows = new HashMap<>();

    public static void clear() {
        windows.clear();
    }

    public static void init() {
        windows.put(Strings.SIGN_IN, new LoginWindow(Config.INPUT_READER, Config.OUTPUT_PRINTER));
        windows.put(Strings.MAIN_MENU, new MainMenuWindow(Config.INPUT_READER, Config.OUTPUT_PRINTER));
        windows.put(Strings.CLIENTS, new ClientsWindow(Config.INPUT_READER, Config.OUTPUT_PRINTER));
        windows.put(Strings.ADD_CLIENT, new AddClientWindow(Config.INPUT_READER, Config.OUTPUT_PRINTER));
    }

    public static IWindow GetWindow(String title) {
        return windows.get(title);
    }
}
