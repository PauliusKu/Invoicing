package main.client.mocks;

import main.client.Strings;
import main.client.interfaces.IOutputPrinter;

import java.util.ArrayList;
import java.util.List;

public class MockPrinter implements IOutputPrinter {
    private final List<String> outputs = new ArrayList<>();
    @Override
    public void printTitle(String title) {
        if (!title.equals(Strings.EMPTY_STRING)) {
            outputs.add(title);
        }
    }

    @Override
    public void printText(String text) {
        if (!text.equals(Strings.EMPTY_STRING)) {
            outputs.add(text);
        }
    }

    @Override
    public void printMessage(String message) {
        if (!message.equals(Strings.EMPTY_STRING)){
            outputs.add(message);
        }
    }

    public List<String> getOutputs() {
        return outputs;
    }
}
