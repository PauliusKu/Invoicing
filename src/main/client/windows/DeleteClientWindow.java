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
import java.util.Locale;
import java.util.Map;

public class DeleteClientWindow extends Window {

    public DeleteClientWindow(IInputReader inputReader, IOutputPrinter outputPrinter) {
        super(inputReader, outputPrinter);
    }

    private IWindow onSuccess_(Map<String, Object> response) {
        IWindow window = Windows.GetWindow(Strings.CLIENTS);
        if (window != null) {
            String message = (String) response.get(Strings.MESSAGE_KEY);
            window.setMessage(message);
            return window.show();
        }
        else{
            return null;
        }
    }

    private IWindow onSuccess(Map<String, Object> response){
        @SuppressWarnings("unchecked")
        List<List<String>> table = (List<List<String>>)response.get(Strings.TABLE);
        List<String> emails = printDeleteOptions(table);
        String deleteOption = inputReader.readString();
        outputPrinter.printTitle(Strings.ARE_YOU_SURE);
        outputPrinter.printText(Strings.ARE_YOU_SURE_);
        outputPrinter.printText(Strings.YES);
        outputPrinter.printText(Strings.NO);
        String yesNoOption = inputReader.readString();
        if (yesNoOption.toLowerCase().startsWith(Strings.Y)) {
            int index = Integer.parseInt(deleteOption) - 1;
            String emailToDelete = emails.get(index);
            response = ClientsController.deleteClient(Config.TOKEN, emailToDelete);
            Config.TOKEN = (String) response.get(Strings.TOKEN);
            if (response.containsKey(Strings.MESSAGE_KEY)){
                return onSuccess_(response);
            }
            else {
                return onError(response);
            }
        }
        else if (yesNoOption.toLowerCase().startsWith(Strings.N)){
            IWindow window = Windows.GetWindow(Strings.CLIENTS);
            if (window != null){
                window.setMessage(Strings.SUCCESS_CLIENT_WAS_NOT_DELETED);
                return window.show();
            }
            else{
                return null;
            }

        }
        else {
            MESSAGE = Strings.UNKNOWN_OPTION_WAS_CHOSEN;
            return show();
        }
    }

    private List<String> printDeleteOptions(List<List<String>> table){
        int i = 1;
        List<String> emails = new ArrayList<>();
        for (var row: table) {
            String email = row.get(2);
            emails.add(email);
            String text = i + ") " + email;
            outputPrinter.printText(text);
            i++;
        }
        return emails;
    }

    private IWindow onError(Map<String, Object> response) {
        String message = (String) response.get(Strings.ERROR_KEY);
        IWindow window = Windows.GetWindow(Strings.CLIENTS);
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
        outputPrinter.printTitle(Strings.DELETE_CLIENT);
        printMessage();
        if (checkExit()){
            return null;
        }
        outputPrinter.printText(Strings.CHOOSE_CLIENT_TO_DELETE);
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
