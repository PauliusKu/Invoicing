package main.client.windows;

import main.client.config.Config;
import main.client.config.Strings;
import main.client.config.Windows;
import main.client.interfaces.IInputReader;
import main.client.interfaces.IOutputPrinter;
import main.client.interfaces.IWindow;
import main.controller.access.ClientsController;

import java.util.List;
import java.util.Map;

public class ClientsWindow extends Window {

    public ClientsWindow(IInputReader inputReader, IOutputPrinter outputPrinter) {
        super(inputReader, outputPrinter);
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
        outputPrinter.printText(Strings.CHOOSE_FROM_THE_FOLLOWING_OPTIONS);
        outputPrinter.printText(Strings.ADD_CLIENT_1);
        outputPrinter.printText(Strings.DELETE_CLIENT_2);
        outputPrinter.printText(Strings.GO_BACK_3);
        String option = inputReader.readString();
        Config.WINDOW_CHANGES++;
        switch (option) {
            case Strings.ONE:
                return Windows.GetWindow(Strings.NEW_CLIENT).show();
            case Strings.TWO:
                return Windows.GetWindow(Strings.DELETE_CLIENT).show();
            case Strings.THREE:
                return Windows.GetWindow(Strings.MAIN_MENU).show();
            default:
                MESSAGE = Strings.UNKNOWN_OPTION_WAS_CHOSEN;
                return show();
        }
    }

    private IWindow onError(Map<String, Object> response) {
        String message = (String) response.get(Strings.ERROR_KEY);
        IWindow window = Windows.GetWindow(Strings.MAIN_MENU);
        if (window != null) {
            window.setMessage(message);
            return window.show();
        }
        else{
            return null;
        }
    }

    @Override
    public IWindow show() {
        outputPrinter.printTitle(Strings.CLIENTS);
        printMessage();
        if (checkExit()){
            return null;
        }
        Map<String, Object> response = ClientsController.getClients(Config.TOKEN);
        Config.TOKEN = (String) response.get(Strings.TOKEN);
        Config.WINDOW_CHANGES++;
        if (response.containsKey(Strings.TABLE)) {
            return onSuccess(response);
        }
        else {
            return onError(response);
        }
    }
}
