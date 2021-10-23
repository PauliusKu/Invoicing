package main.client.windows;

import main.client.config.Config;
import main.client.config.Strings;
import main.client.config.Windows;
import main.client.interfaces.IInputReader;
import main.client.interfaces.IOutputPrinter;
import main.client.interfaces.IWindow;
import main.controller.access.ClientsController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddClientWindow extends Window {
    public AddClientWindow(IInputReader inputReader, IOutputPrinter outputPrinter) {
        super(inputReader, outputPrinter);
    }

    private IWindow onSuccess(Map<String, Object> response) {
        String message = (String) response.get(Strings.MESSAGE_KEY);
        IWindow window = Windows.GetWindow(Strings.CLIENTS);
        if (window != null) {
            window.setMessage(message);
            return window.show();
        }
        else{
            return null;
        }
    }

    private IWindow onError(Map<String, Object> response) {
        String message = (String) response.get(Strings.ERROR_KEY);
        IWindow window = Windows.GetWindow(Strings.NEW_CLIENT);
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
        outputPrinter.printTitle(Strings.NEW_CLIENT);
        printMessage();
        if (checkExit()){
            return null;
        }
        outputPrinter.printText(Strings.WRITE_CLIENTS_FIRST_NAME);
        String firstName = inputReader.readString();
        outputPrinter.printText(Strings.WRITE_CLIENTS_LAST_NAME);
        String lastName = inputReader.readString();
        outputPrinter.printText(Strings.WRITE_CLIENTS_ORGANIZATION);
        String organization = inputReader.readString();
        outputPrinter.printText(Strings.WRITE_CLIENTS_EMAIL);
        String email = inputReader.readString();
        List<String> clientDetails = new ArrayList<>();
        clientDetails.add(firstName);
        clientDetails.add(lastName);
        clientDetails.add(organization);
        clientDetails.add(email);
        Map<String, Object> response = ClientsController.addClient(Config.TOKEN, clientDetails);
        Config.TOKEN = (String) response.get(Strings.TOKEN);
        Config.WINDOW_CHANGES++;
        if (response.containsKey(Strings.MESSAGE_KEY)){
            return onSuccess(response);
        }
        else{
            return onError(response);
        }
    }
}
