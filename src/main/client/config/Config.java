package main.client.config;

import main.client.interfaces.IInputReader;
import main.client.interfaces.IOutputPrinter;

public class Config {
    public static String START_WINDOW = Strings.SIGN_IN;
    public static IInputReader INPUT_READER;
    public static IOutputPrinter OUTPUT_PRINTER;
    public static boolean TEST_MODE = true;
    public static int WINDOW_CHANGES = 0;
    public static int EXIT_AFTER_WINDOW_CHANGES = 1;
    public static String TOKEN;
}
