package main.client;


import main.client.interfaces.IInputReader;
import main.client.interfaces.IOutputPrinter;
import main.client.interfaces.IWindow;

public class Client {
    public static void run(){
        Windows.GetWindow(Config.START_WINDOW).show();
    }
}
