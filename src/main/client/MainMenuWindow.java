package main.client;

import main.client.interfaces.IOutputPrinter;
import main.client.interfaces.IWindow;

public record MainMenuWindow(IOutputPrinter outputPrinter) implements IWindow {
    private static String MESSAGE;

    private void printMessage() {
        outputPrinter.printMessage(MESSAGE);
        MESSAGE = Strings.EMPTY_STRING;
    }


    @Override
    public void setMessage(String message) {
        MESSAGE = message;
    }

    @Override
    public IWindow show() {
        outputPrinter.printTitle(Strings.MAIN_MENU);
        printMessage();
        return null;
    }
}
