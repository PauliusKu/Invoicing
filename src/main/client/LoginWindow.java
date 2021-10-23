package main.client;

import main.client.interfaces.IInputReader;
import main.client.interfaces.IOutputPrinter;
import main.client.interfaces.IWindow;
import main.controller.access.LoginController;

import java.util.Map;

import static main.client.Strings.MESSAGE_KEY;

public class LoginWindow implements IWindow {
    //IMMUTABLE FIELDS
    private final IInputReader inputReader;
    private final IOutputPrinter outputPrinter;

    //MUTABLE FIELDS

    private String MESSAGE = Strings.WELCOME_TO_INVOICING;

    public LoginWindow(IInputReader inputReader, IOutputPrinter outputPrinter) {
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

    private IWindow onSuccess(Map<String, String> response) {
        Config.TOKEN = response.get(Strings.TOKEN);
        IWindow window = Windows.GetWindow(Strings.MAIN_MENU);
        if (window != null) {
            String message = response.get(Strings.MESSAGE_KEY);
            window.setMessage(message);
            return window.show();
        }
        else{
            return null;
        }
    }

    private IWindow onError(Map<String, String> response) {
        String message = response.get(Strings.ERROR_KEY);
        this.setMessage(message);
        return show();
    }

    @Override
    public void setMessage(String message) {
        MESSAGE = message;
    }

    @Override
    public IWindow show(){
        outputPrinter.printTitle(Strings.SIGN_IN);
        printMessage();
        if (checkExit()) {
            return null;
        }
        outputPrinter.printText(Strings.WRITE_YOUR_EMAIL);
        String email = inputReader.readString();
        outputPrinter.printText(Strings.WRITE_YOUR_PASSWORD);
        String password = inputReader.readString();
        Map<String, String> response = LoginController.login(email, password);
        Config.WINDOW_CHANGES++;
        if (response.containsKey(Strings.TOKEN)) {
            return onSuccess(response);
        }
        else {
            return onError(response);
        }

    }
}
