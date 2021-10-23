package main.client.interfaces;

import java.util.List;

public interface IOutputPrinter {
    void printTitle(String title);
    void printText(String text);
    void printMessage(String message);
    void printTable(List<List<String>> table);
}
