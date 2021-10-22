package main.client;

import main.client.implementations.ConsolePrinter;
import main.client.implementations.ConsoleReader;

public class Main {
    public static void main(String[] args){
        Config.TEST_MODE = false;
        Config.INPUT_READER = new ConsoleReader();
        Config.OUTPUT_PRINTER = new ConsolePrinter();
        Client.run();
    }
}
