package main.client.implementations;

import main.client.interfaces.IInputReader;

import java.util.Scanner;

public class ConsoleReader implements IInputReader {
    @Override
    public String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
