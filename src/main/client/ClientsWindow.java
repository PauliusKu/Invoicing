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

    private static String MESSAGE = "";

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

    private List<List<String>> createTable(List<List<String>> info) {
        List<String> header = List.of(
                Strings.FIRST_NAME,
                Strings.LAST_NAME,
                Strings.EMAIL,
                Strings.ORGANIZATION,
                Strings.INVOICED_AMOUNT,
                Strings.RECEIVED_AMOUNT
        );
        info.add(0, header);
        return info;
    }

    private IWindow onSuccess(Map<String, Object> response) {
        @SuppressWarnings("unchecked")
        List<List<String>> table = (List<List<String>>)response.get(Strings.TABLE);
        int numberOfClients = table.size();
        String numberOfClientsText = Strings.NUMBER_OF_CLIENTS_THAT_YOU_HAVE + numberOfClients;
        outputPrinter.printText(numberOfClientsText);
        outputPrinter.printText(Strings.CLIENTS_INFORMATION);
        outputPrinter.printTable(createTable(table));
        return null;
    }

    private IWindow onError(Map<String, Object> response) {
        String message = (String) response.get(Strings.ERROR_KEY);
        IWindow window = Windows.GetWindow(Strings.MAIN_MENU);
        if (window != null) {
            window.setMessage(message);
            return window.show();
        }
        return null;
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
        Map<String, Object> response = ClientsController.getClients(Config.TOKEN);
        Config.WINDOW_CHANGES++;
        if (response.containsKey(Strings.TABLE)) {
            return onSuccess(response);
        }
        else {
            return onError(response);
        }
    }
}
