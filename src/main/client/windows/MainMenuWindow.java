package main.client.windows;

import main.client.config.Config;
import main.client.config.Strings;
import main.client.config.Windows;
import main.client.interfaces.IInputReader;
import main.client.interfaces.IOutputPrinter;
import main.client.interfaces.IWindow;

public class MainMenuWindow extends Window {

    public MainMenuWindow(IInputReader inputReader, IOutputPrinter outputPrinter) {
        super(inputReader, outputPrinter);
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
