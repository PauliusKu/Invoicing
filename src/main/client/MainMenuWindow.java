package main.client;

import main.client.interfaces.IInputReader;
import main.client.interfaces.IOutputPrinter;
import main.client.interfaces.IWindow;

public class MainMenuWindow implements IWindow {
    private final IInputReader inputReader;
    private final IOutputPrinter outputPrinter;

    private static String MESSAGE;


    public MainMenuWindow(IInputReader inputReader, IOutputPrinter outputPrinter) {
        this.inputReader = inputReader;
        this.outputPrinter = outputPrinter;
    }

    private boolean checkExit() {
        return Config.TEST_MODE && (Config.WINDOW_CHANGES >= Config.EXIT_AFTER_WINDOW_CHANGES);
    }

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
        if (checkExit()){
            return null;
        }
        outputPrinter.printText(Strings.CHOOSE_FROM_THE_FOLLOWING_OPTIONS);
        outputPrinter.printText(Strings.VIEW_CLIENTS_1);
        outputPrinter.printText(Strings.LOGOUT_2);
        String option = inputReader.readString();
        Config.WINDOW_CHANGES++;
        if (option.equals(Strings.ONE)) {
            return Windows.GetWindow(Strings.CLIENTS).show();
        }
        else if (option.equals(Strings.TWO)){
            Config.TOKEN = null;
            return Windows.GetWindow(Strings.SIGN_IN).show();
        }
        else {
            MESSAGE = Strings.UNKNOWN_OPTION_WAS_CHOSEN;
            return show();
        }
    }
}
