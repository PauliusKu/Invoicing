package main.client.implementations;

import main.client.config.Strings;
import main.client.interfaces.IOutputPrinter;

import java.util.List;

public class ConsolePrinter implements IOutputPrinter {
    @Override
    public void printTitle(String title) {
        System.out.println(Strings.TITLE + title);
    }

    @Override
    public void printText(String text) {
        System.out.println(text);
    }

    @Override
    public void printMessage(String message) {
        System.out.println(Strings.MESSAGE + message);
    }

    @Override
    public void printTable(List<List<String>> table) {
        System.out.println(table.toString());
    }
}
