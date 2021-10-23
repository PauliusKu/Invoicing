package main.client.windows;

import main.client.config.Config;
import main.client.config.Strings;
import main.client.config.Windows;
import main.client.interfaces.IInputReader;
import main.client.interfaces.IOutputPrinter;
import main.client.interfaces.IWindow;
import main.controller.access.LoginController;

import java.util.Map;

public class LoginWindow extends Window {

    public LoginWindow(IInputReader inputReader, IOutputPrinter outputPrinter) {
        super(inputReader, outputPrinter);
        MESSAGE = Strings.WELCOME_TO_INVOICING;
    }

    private IWindow onSuccess(Map<String, Object> response) {
        Config.TOKEN = (String) response.get(Strings.TOKEN);
        IWindow window = Windows.GetWindow(Strings.MAIN_MENU);
        if (window != null) {
            String message = (String) response.get(Strings.MESSAGE_KEY);
            window.setMessage(message);
            return window.show();
        }
        else{
            return null;
        }
    }

    private IWindow onError(Map<String, Object> response) {
        String message = (String)response.get(Strings.ERROR_KEY);
        this.setMessage(message);
        return show();
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
        Map<String, Object> response = LoginController.login(email, password);
        Config.WINDOW_CHANGES++;
        if (response.containsKey(Strings.TOKEN)) {
            return onSuccess(response);
        }
        else {
            return onError(response);
        }

    }
}
