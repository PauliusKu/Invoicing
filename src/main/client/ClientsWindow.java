package main.client;

import main.client.interfaces.IInputReader;
import main.client.interfaces.IOutputPrinter;
import main.client.interfaces.IWindow;
import main.controller.access.ClientsController;

import java.util.List;
import java.util.Map;

public class ClientsWindow implements IWindow {
    private final IInputReader inputReader;
    private final IOutputPrinter outputPrinter;

    private static String MESSAGE;

    public ClientsWindow(IInputReader inputReader, IOutputPrinter outputPrinter) {
        this.inputReader = inputReader;
        this.outputPrinter = outputPrinter;
    }

    private void printMessage() {
        outputPrinter.printMessage(MESSAGE);
        MESSAGE = Strings.EMPTY_STRING;
    }

    private boolean checkExit() {
        return Config.TEST_MODE && (Config.WINDOW_CHANGES >= Config.EXIT_AFTER_WINDOW_CHANGES);
    }

    @Override
    public void setMessage(String message) {
        MESSAGE = message;
    }

    @Override
    public IWindow show() {
        outputPrinter.printTitle(Strings.MAIN_MENU);
        printMessage();
        if (checkExit()){
            return null;
        }
        //get clients from backend


        return null;
    }
}
