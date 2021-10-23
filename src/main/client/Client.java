package main.client;

public class Client {
    public static void run(){
        Config.WINDOW_CHANGES = 0;
        Windows.init();
        Windows.GetWindow(Config.START_WINDOW).show();
        Windows.clear();
    }
}
