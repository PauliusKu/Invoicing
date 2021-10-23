package main.client.windows;

import main.client.config.Config;
import main.client.config.Strings;
import main.client.interfaces.IInputReader;
import main.client.interfaces.IOutputPrinter;
import main.client.interfaces.IWindow;

public class Window implements IWindow {
    protected final IInputReader inputReader;
    protected final IOutputPrinter outputPrinter;
    protected static String MESSAGE;

    public Window(IInputReader inputReader, IOutputPrinter outputPrinter) {
        this.inputReader = inputReader;
        this.outputPrinter = outputPrinter;
    }

    protected boolean checkExit() {
        return Config.TEST_MODE && (Config.WINDOW_CHANGES >= Config.EXIT_AFTER_WINDOW_CHANGES);
    }

    protected void printMessage() {
        outputPrinter.printMessage(MESSAGE);
        MESSAGE = Strings.EMPTY_STRING;
    }

    @Override
    public void setMessage(String message) {
        MESSAGE = message;
    }

    @Override
    public IWindow show() {
        return null;
    }
}
