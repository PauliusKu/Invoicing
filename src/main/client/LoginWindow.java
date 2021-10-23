package main.client;

import main.client.interfaces.IInputReader;
import main.client.interfaces.IOutputPrinter;
import main.client.interfaces.IWindow;
import main.controller.access.LoginController;

public class LoginWindow implements IWindow {
    //IMMUTABLE FIELDS
    private final boolean TEST_MODE = Config.TEST_MODE;

    private final IInputReader inputReader;
    private final IOutputPrinter outputPrinter;

    //MUTABLE FIELDS
    private static int EXIT_AFTER = Config.EXIT_AFTER;
    private static String MESSAGE = Strings.WELCOME_TO_INVOICING;


    public LoginWindow(IInputReader inputReader, IOutputPrinter outputPrinter) {
        this.inputReader = inputReader;
        this.outputPrinter = outputPrinter;
    }

    private void printMessage() {
        outputPrinter.printMessage(MESSAGE);
        MESSAGE = Strings.EMPTY_STRING;
    }

    private IWindow onSuccess(String response) {
        IWindow window = Windows.GetWindow(Strings.MAIN_MENU);
        if (window != null) {
            window.setMessage(response);
            return window.show();
        }
        else{
            return null;
        }
    }

    private IWindow onError(String response) {
        EXIT_AFTER--;
        if (TEST_MODE && EXIT_AFTER == 0) {
            return null;
        }
        else {
            String message = Strings.ERROR + response;
            this.setMessage(message);
            return show();
        }
    }

    @Override
    public void setMessage(String message) {
        MESSAGE = message;
    }

    @Override
    public IWindow show(){
        outputPrinter.printTitle(Strings.SIGN_IN);
        printMessage();
        outputPrinter.printText(Strings.WRITE_YOUR_EMAIL);
        String email = inputReader.readString();
        outputPrinter.printText(Strings.WRITE_YOUR_PASSWORD);
        String password = inputReader.readString();
        String response = LoginController.login(email, password);
        if (response.startsWith(Strings.SUCCESS)) {
            return onSuccess(response);
        }
        else {
            return onError(response);
        }

    }
}
